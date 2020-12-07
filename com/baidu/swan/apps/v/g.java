package com.baidu.swan.apps.v;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes25.dex */
public class g implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile g deX;
    private int mActivityCount;
    private boolean mIsForeground = false;

    public static g aCy() {
        if (deX == null) {
            synchronized (g.class) {
                if (deX == null) {
                    deX = new g();
                }
            }
        }
        return deX;
    }

    private g() {
    }

    public void aCz() {
        com.baidu.swan.apps.t.a.aza().registerActivityLifecycleCallbacks(this);
    }

    public void aCA() {
        com.baidu.swan.apps.t.a.aza().unregisterActivityLifecycleCallbacks(this);
    }

    public boolean isForeground() {
        return this.mIsForeground;
    }

    public void setForeground(boolean z) {
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
