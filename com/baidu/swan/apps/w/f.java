package com.baidu.swan.apps.w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static volatile f ayA;
    private boolean arn = false;
    private int ayB;

    public static f Ee() {
        if (ayA == null) {
            synchronized (f.class) {
                if (ayA == null) {
                    ayA = new f();
                }
            }
        }
        return ayA;
    }

    private f() {
    }

    public void Ef() {
        com.baidu.swan.apps.u.a.Cy().registerActivityLifecycleCallbacks(this);
    }

    public void Eg() {
        com.baidu.swan.apps.u.a.Cy().unregisterActivityLifecycleCallbacks(this);
    }

    private void E(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.arn = true;
        }
    }

    private void F(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.arn = false;
        }
    }

    public boolean Eh() {
        return this.arn;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.ayB++;
        if (this.ayB == 1) {
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
        this.ayB--;
        if (this.ayB == 0) {
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
