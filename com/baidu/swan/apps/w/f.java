package com.baidu.swan.apps.w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f aAI;
    private int aAJ;
    private boolean asA = false;

    public static f GM() {
        if (aAI == null) {
            synchronized (f.class) {
                if (aAI == null) {
                    aAI = new f();
                }
            }
        }
        return aAI;
    }

    private f() {
    }

    public void GN() {
        com.baidu.swan.apps.u.a.Eo().registerActivityLifecycleCallbacks(this);
    }

    public void GO() {
        com.baidu.swan.apps.u.a.Eo().unregisterActivityLifecycleCallbacks(this);
    }

    private void H(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onBackgroundToForeground");
            }
            this.asA = true;
        }
    }

    private void I(Activity activity) {
        if (activity instanceof SwanAppActivity) {
            if (DEBUG) {
                Log.d("SwanAppLifecycle", "onForegroundToBackground");
            }
            this.asA = false;
        }
    }

    public boolean GP() {
        return this.asA;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.aAJ++;
        if (this.aAJ == 1) {
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
        this.aAJ--;
        if (this.aAJ == 0) {
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
