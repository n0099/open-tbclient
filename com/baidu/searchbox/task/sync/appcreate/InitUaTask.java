package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.switchs.ImgUaSwitch;
import com.baidu.tieba.ly5;
/* loaded from: classes4.dex */
public class InitUaTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_InitUaTask";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        if (!ImgUaSwitch.isOn()) {
            return;
        }
        System.setProperty("http.agent", ly5.b());
    }
}
