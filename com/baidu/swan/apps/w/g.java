package com.baidu.swan.apps.w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class g implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile g ciF;
    private int mActivityCount;
    private boolean mIsForeground = false;

    public static g aie() {
        if (ciF == null) {
            synchronized (g.class) {
                if (ciF == null) {
                    ciF = new g();
                }
            }
        }
        return ciF;
    }

    private g() {
    }

    public void aif() {
        com.baidu.swan.apps.u.a.aeR().registerActivityLifecycleCallbacks(this);
    }

    public void aig() {
        com.baidu.swan.apps.u.a.aeR().unregisterActivityLifecycleCallbacks(this);
    }

    public boolean isForeground() {
        return this.mIsForeground;
    }

    public void ed(boolean z) {
        this.mIsForeground = z;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.mActivityCount++;
        if (this.mActivityCount == 1) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.mIsForeground = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.mIsForeground = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.mActivityCount--;
        if (this.mActivityCount == 0) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.mIsForeground = false;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }
}
