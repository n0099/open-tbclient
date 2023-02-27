package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.util.ChannelInitHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class InitGlobalDataTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_InitGlobalData";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        if (TbadkCoreApplication.getClientId() == null) {
            TbadkCoreApplication.setClientId(TbadkCoreApplication.getInst().readClientId(TbadkCoreApplication.getInst().getContext()));
        }
        if (!ChannelInitHelper.hasInitFinish()) {
            ChannelInitHelper.init();
        }
    }
}
