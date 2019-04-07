package com.baidu.swan.apps.w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f ayE;
    private boolean ars = false;
    private int ayF;

    public static f Ec() {
        if (ayE == null) {
            synchronized (f.class) {
                if (ayE == null) {
                    ayE = new f();
                }
            }
        }
        return ayE;
    }

    private f() {
    }

    public void Ed() {
        com.baidu.swan.apps.u.a.Cw().registerActivityLifecycleCallbacks(this);
    }

    public void Ee() {
        com.baidu.swan.apps.u.a.Cw().unregisterActivityLifecycleCallbacks(this);
    }

    private void E(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.ars = true;
        }
    }

    private void F(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.ars = false;
        }
    }

    public boolean Ef() {
        return this.ars;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.ayF++;
        if (this.ayF == 1) {
            E(activity);
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
        this.ayF--;
        if (this.ayF == 0) {
            F(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }
}
