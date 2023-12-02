package com.baidu.searchbox.task.sync.appcreate;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.io.FileUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.StartupCountStats;
import com.baidu.searchbox.StartupCountStatsController;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.aea;
import com.baidu.tieba.bh;
import com.baidu.tieba.ih;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.tieba.iq4;
/* loaded from: classes4.dex */
public class InitSDKTask extends LaunchTask {
    public aea cyberMediaContextDef = new aea();

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
        registerStartupCountStats();
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

    private void initSwanKv() {
        try {
            KVStorageFactory.getSharedPreferences("UniKVTest", 0).edit().putInt(DebugActiveUploadResult.SOURCE, 0).apply();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    private void initTBTaskSDK() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            iq4.f().g(TbadkCoreApplication.getInst());
        }
    }

    private void initTurbonet() {
        try {
            String a = ih.a("libturbonet.so");
            if (FileUtils.exists(a)) {
                bh.d(TbadkCoreApplication.getInst().getApplicationContext().getClassLoader(), a);
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private void registerStartupCountStats() {
        StartupCountStats.setStartupCountStatsRule(new StartupCountStats.StatsRule() { // from class: com.baidu.searchbox.task.sync.appcreate.InitSDKTask.1
            @Override // com.baidu.searchbox.StartupCountStats.StatsRule
            @Nullable
            public boolean shouldStats(Activity activity) {
                if (activity instanceof ImageViewerActivity) {
                    return false;
                }
                return super.shouldStats(activity);
            }
        });
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initLibCXX();
        initSwanKv();
        initDeviceSdk();
        initCountStats();
        initGrowthSdk();
        initTBTaskSDK();
        initTurbonet();
        initCyberPlayerSdk();
    }
}
