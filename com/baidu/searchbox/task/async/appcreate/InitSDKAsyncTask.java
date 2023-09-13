package com.baidu.searchbox.task.async.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.ruka.Ruka;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ina;
/* loaded from: classes4.dex */
public class InitSDKAsyncTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitSDKAsync";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
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
        initRuka();
    }

    private void initStatSdk() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            ina.b().d(TbadkCoreApplication.getInst());
            ina.b().a(TbadkCoreApplication.getInst());
            ina b = ina.b();
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            TbadkCoreApplication.getInst();
            b.f(inst, TbadkCoreApplication.getFrom(), true);
        }
    }
}
