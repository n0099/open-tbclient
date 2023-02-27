package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.StartupCountStatsController;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ot4;
/* loaded from: classes3.dex */
public class InitSDKTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitSDK";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initCountStats() {
        StartupCountStatsController.resetDefaultUploadID();
        StartupCountStatsController.init();
    }

    private void initDeviceSdk() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            DeviceInfoManager.INSTANCE.init(511);
        }
    }

    private void initGrowthSdk() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            GrowthStatsUtil.statisticDeviceInfo();
        }
    }

    private void initTBTaskSDK() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            ot4.f().g(TbadkCoreApplication.getInst());
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initDeviceSdk();
        initCountStats();
        initGrowthSdk();
        initTBTaskSDK();
    }
}
