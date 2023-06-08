package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.io.FileUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.StartupCountStatsController;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.bw4;
import com.baidu.tieba.gm;
import com.baidu.tieba.nm;
import com.baidu.tieba.wi9;
/* loaded from: classes4.dex */
public class InitSDKTask extends LaunchTask {
    public wi9 cyberMediaContextDef = new wi9();

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

    private void initCyberPlayerSdk() {
        CyberPlayerManager.setCyberMediaContext(this.cyberMediaContextDef);
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

    private void initLibCXX() {
        try {
            System.loadLibrary(SwanKV.LIB_CPP_SHARED);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    private void initTBTaskSDK() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            bw4.f().g(TbadkCoreApplication.getInst());
        }
    }

    private void initTurbonet() {
        try {
            String a = nm.a("libturbonet.so");
            if (FileUtils.exists(a)) {
                gm.d(TbadkCoreApplication.getInst().getApplicationContext().getClassLoader(), a);
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initLibCXX();
        initDeviceSdk();
        initCountStats();
        initGrowthSdk();
        initTBTaskSDK();
        initCyberPlayerSdk();
    }
}
