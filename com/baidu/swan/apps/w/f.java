package com.baidu.swan.apps.w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f aTE;
    private boolean aLy = false;
    private int aTF;

    public static f LH() {
        if (aTE == null) {
            synchronized (f.class) {
                if (aTE == null) {
                    aTE = new f();
                }
            }
        }
        return aTE;
    }

    private f() {
    }

    public void LI() {
        com.baidu.swan.apps.u.a.Jj().registerActivityLifecycleCallbacks(this);
    }

    public void LJ() {
        com.baidu.swan.apps.u.a.Jj().unregisterActivityLifecycleCallbacks(this);
    }

    private void G(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.aLy = true;
        }
    }

    private void H(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.aLy = false;
        }
    }

    public boolean LK() {
        return this.aLy;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.aTF++;
        if (this.aTF == 1) {
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
        this.aTF--;
        if (this.aTF == 0) {
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
