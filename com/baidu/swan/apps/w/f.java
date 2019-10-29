package com.baidu.swan.apps.w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f aTW;
    private boolean aLQ = false;
    private int aTX;

    public static f LG() {
        if (aTW == null) {
            synchronized (f.class) {
                if (aTW == null) {
                    aTW = new f();
                }
            }
        }
        return aTW;
    }

    private f() {
    }

    public void LH() {
        com.baidu.swan.apps.u.a.Ji().registerActivityLifecycleCallbacks(this);
    }

    public void LI() {
        com.baidu.swan.apps.u.a.Ji().unregisterActivityLifecycleCallbacks(this);
    }

    private void G(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.aLQ = true;
        }
    }

    private void H(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.aLQ = false;
        }
    }

    public boolean LJ() {
        return this.aLQ;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.aTX++;
        if (this.aTX == 1) {
            G(activity);
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
        this.aTX--;
        if (this.aTX == 0) {
            H(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }
}
