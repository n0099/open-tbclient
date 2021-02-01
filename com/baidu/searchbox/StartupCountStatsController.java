package com.baidu.searchbox;

import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.GlobalActivityLifecycle;
/* loaded from: classes7.dex */
public class StartupCountStatsController {
    private static volatile boolean hasInit = false;

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
}
