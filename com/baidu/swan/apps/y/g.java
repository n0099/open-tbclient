package com.baidu.swan.apps.y;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes11.dex */
public class g implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile g bzR;
    private int mActivityCount;
    private boolean mIsForeground = false;

    public static g Xa() {
        if (bzR == null) {
            synchronized (g.class) {
                if (bzR == null) {
                    bzR = new g();
                }
            }
        }
        return bzR;
    }

    private g() {
    }

    public void Xb() {
        com.baidu.swan.apps.w.a.TZ().registerActivityLifecycleCallbacks(this);
    }

    public void Xc() {
        com.baidu.swan.apps.w.a.TZ().unregisterActivityLifecycleCallbacks(this);
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
