package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.adp.framework.cmdRouter.CmdRouter;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.m25;
import com.baidu.tieba.on5;
/* loaded from: classes4.dex */
public class InitCmdRouterAndStaticTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitCmdRouterAndStatic";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initTasks() {
        long currentTimeMillis = System.currentTimeMillis();
        m25.a();
        on5.a().t(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        CmdRouter.init(TbadkCoreApplication.getInst());
        initTasks();
    }
}
