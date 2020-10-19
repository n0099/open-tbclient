package com.baidu.searchbox.appframework;

import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes9.dex */
public class GlobalActivityLifecycle extends BdBoxActivityLifecycle {
    private static GlobalActivityLifecycle sInstance;

    private GlobalActivityLifecycle() {
    }

    public static GlobalActivityLifecycle getInstance() {
        if (sInstance == null) {
            synchronized (GlobalActivityLifecycle.class) {
                if (sInstance == null) {
                    sInstance = new GlobalActivityLifecycle();
                    AppRuntime.getApplication().registerActivityLifecycleCallbacks(sInstance);
                }
            }
        }
        return sInstance;
    }
}
