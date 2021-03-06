package me.vrekt.arc.data.moving.task;

import me.vrekt.arc.data.moving.MovingData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MovingUpdateTask extends BukkitRunnable {

    @Override
    public void run() {
        // loop through all players and update air data.
        for (Player player : Bukkit.getOnlinePlayers()) {
            MovingData data = MovingData.getData(player);
            if (!data.isOnGround()) {
                int airTicks = data.getAirTicks();
                data.setAirTicks(airTicks >= 255 ? 255 : airTicks + 1);
            } else {
                data.setAirTicks(0);
            }
        }
    }

}
