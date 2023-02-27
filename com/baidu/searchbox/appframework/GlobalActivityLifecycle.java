package com.baidu.searchbox.appframework;

import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class GlobalActivityLifecycle extends BdBoxActivityLifecycle {
    public static GlobalActivityLifecycle sInstance;

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
