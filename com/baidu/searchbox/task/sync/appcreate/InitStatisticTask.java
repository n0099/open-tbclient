package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.it5;
/* loaded from: classes4.dex */
public class InitStatisticTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitStatistic";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.init(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().isMainProcess(false));
        it5.a().F(System.currentTimeMillis() - currentTimeMillis);
    }
}
