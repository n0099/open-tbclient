package com.baidu.searchbox.task.async.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.ruka.Ruka;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.br9;
import com.baidu.tieba.cr9;
/* loaded from: classes2.dex */
public class InitSDKAsyncTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitSDKAsync";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initJpusbSdk() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            br9.b().d(TbadkCoreApplication.getInst());
        }
    }

    private void initRuka() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            Ruka.startAnrMonitor(TbadkCoreApplication.getInst());
            Ruka.startLooperMonitor(TbadkCoreApplication.getInst());
            Ruka.startBlockMonitor(TbadkCoreApplication.getInst());
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initStatSdk();
        initJpusbSdk();
        initRuka();
    }

    private void initStatSdk() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            cr9.b().d(TbadkCoreApplication.getInst());
            cr9.b().a(TbadkCoreApplication.getInst());
            cr9 b = cr9.b();
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            TbadkCoreApplication.getInst();
            b.f(inst, TbadkCoreApplication.getFrom(), true);
        }
    }
}
