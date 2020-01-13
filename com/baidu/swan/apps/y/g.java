package com.baidu.swan.apps.y;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes10.dex */
public class g implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile g bvv;
    private int mActivityCount;
    private boolean mIsForeground = false;

    public static g UH() {
        if (bvv == null) {
            synchronized (g.class) {
                if (bvv == null) {
                    bvv = new g();
                }
            }
        }
        return bvv;
    }

    private g() {
    }

    public void UI() {
        com.baidu.swan.apps.w.a.RG().registerActivityLifecycleCallbacks(this);
    }

    public void UJ() {
        com.baidu.swan.apps.w.a.RG().unregisterActivityLifecycleCallbacks(this);
    }

    private void onBackgroundToForeground(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.mIsForeground = true;
        }
    }

    private void onForegroundToBackground(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.mIsForeground = false;
        }
    }

    public boolean isForeground() {
        return this.mIsForeground;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.mActivityCount++;
        if (this.mActivityCount == 1) {
            onBackgroundToForeground(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.mActivityCount--;
        if (this.mActivityCount == 0) {
            onForegroundToBackground(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }
}
