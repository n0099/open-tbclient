package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.adp.framework.cmdRouter.CmdRouter;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.gu5;
import com.baidu.tieba.q85;
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
        q85.a();
        gu5.b().u(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        CmdRouter.init(TbadkCoreApplication.getInst());
        initTasks();
    }
}
