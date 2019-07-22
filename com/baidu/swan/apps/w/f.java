package com.baidu.swan.apps.w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f aAk;
    private int aAl;
    private boolean asc = false;

    public static f GI() {
        if (aAk == null) {
            synchronized (f.class) {
                if (aAk == null) {
                    aAk = new f();
                }
            }
        }
        return aAk;
    }

    private f() {
    }

    public void GJ() {
        com.baidu.swan.apps.u.a.Ek().registerActivityLifecycleCallbacks(this);
    }

    public void GK() {
        com.baidu.swan.apps.u.a.Ek().unregisterActivityLifecycleCallbacks(this);
    }

    private void H(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.asc = true;
        }
    }

    private void I(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.asc = false;
        }
    }

    public boolean GL() {
        return this.asc;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.aAl++;
        if (this.aAl == 1) {
            H(activity);
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
        this.aAl--;
        if (this.aAl == 0) {
            I(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }
}
