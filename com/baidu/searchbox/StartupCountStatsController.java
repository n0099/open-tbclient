package com.baidu.searchbox;

import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.GlobalActivityLifecycle;
/* loaded from: classes2.dex */
public class StartupCountStatsController {
    public static volatile boolean hasInit;

    public static void init() {
        if (!hasInit) {
            synchronized (StartupCountStatsController.class) {
                if (!hasInit) {
                    if (BdBoxActivityManager.getMainGlobalActivityLifecycle() == null) {
                        BdBoxActivityManager.setMainGlobalActivityLifecycle(GlobalActivityLifecycle.getInstance());
                    }
                    BdBoxActivityManager.registerLifeCycle(new StartupCountStats());
                    hasInit = true;
                }
            }
        }
    }

    public static void resetDefaultUploadID() {
        StartupCountStats.setStartupCountUploadId(StartupCountStatsUtils.MEG_STARTUP_UBC_ID);
        StartupCountStats.setUseDurationUploadId("18");
    }
}
