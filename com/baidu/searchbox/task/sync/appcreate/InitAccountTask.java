package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.o05;
/* loaded from: classes4.dex */
public class InitAccountTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitAccount";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        o05.t().z();
    }
}
