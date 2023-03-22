package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.adp.framework.cmdRouter.CmdRouter;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.a25;
import com.baidu.tieba.fl5;
import com.baidu.tieba.m35;
/* loaded from: classes2.dex */
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
        a25.a();
        fl5.b().u(System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        boolean z = false;
        if (m35.m().n("static_opt_open", 0) > 0) {
            z = true;
        }
        if (z) {
            CmdRouter.init(TbadkCoreApplication.getInst());
        }
        initTasks();
    }
}
