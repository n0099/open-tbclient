package com.baidu.swan.apps.w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f ayB;
    private boolean aro = false;
    private int ayC;

    public static f Ee() {
        if (ayB == null) {
            synchronized (f.class) {
                if (ayB == null) {
                    ayB = new f();
                }
            }
        }
        return ayB;
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
            this.aro = true;
        }
    }

    private void F(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.aro = false;
        }
    }

    public boolean Eh() {
        return this.aro;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.ayC++;
        if (this.ayC == 1) {
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
        this.ayC--;
        if (this.ayC == 0) {
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
