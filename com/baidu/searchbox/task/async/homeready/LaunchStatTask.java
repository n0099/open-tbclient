package com.baidu.searchbox.task.async.homeready;

import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes4.dex */
public class LaunchStatTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_LaunchStat";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    private void stat() {
        TiebaStatic.log(new StatisticItem("app_idle").param("obj_type", System.currentTimeMillis() - SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp()));
        new SmartLaunchStats().stats();
        new TTIStats().stats();
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        stat();
    }
}
