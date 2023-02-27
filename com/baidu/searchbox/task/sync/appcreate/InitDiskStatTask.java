package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.download.center.clearcache.DiskManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
/* loaded from: classes2.dex */
public class InitDiskStatTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitDiskStat";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        DiskManager.INSTANCE.startCheckDiskStateAndNotify();
    }
}
