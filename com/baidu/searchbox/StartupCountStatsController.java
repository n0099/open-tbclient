package com.baidu.searchbox;

import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.GlobalActivityLifecycle;
/* loaded from: classes.dex */
public class StartupCountStatsController {
    public static volatile boolean hasInit = false;

    public static void init() {
        if (hasInit) {
            return;
        }
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
