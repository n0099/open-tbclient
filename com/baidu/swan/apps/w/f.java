package com.baidu.swan.apps.w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f ayF;
    private boolean art = false;
    private int ayG;

    public static f Ec() {
        if (ayF == null) {
            synchronized (f.class) {
                if (ayF == null) {
                    ayF = new f();
                }
            }
        }
        return ayF;
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
            this.art = true;
        }
    }

    private void F(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.art = false;
        }
    }

    public boolean Ef() {
        return this.art;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.ayG++;
        if (this.ayG == 1) {
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
        this.ayG--;
        if (this.ayG == 0) {
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
