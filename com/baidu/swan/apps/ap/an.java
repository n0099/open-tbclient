package com.baidu.swan.apps.ap;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes25.dex */
public class an {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dJt;
    @Nullable
    private com.baidu.swan.apps.v.a dJp = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ap.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aOz()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ap.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r azm = com.baidu.swan.apps.t.a.azm();
                            ComponentName component = intent.getComponent();
                            if (an.this.dJq && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && azm != null && component != null && TextUtils.equals(azm.ajV(), component.getClassName())) {
                                if (an.this.dJr) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aOy = b.aOy();
                                if (c.aOE() && b.aOA()) {
                                    c = aOy.b(activity, an.this.dJs, false);
                                } else {
                                    c = aOy.c(an.this.dJs, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.dJs);
                                }
                                aOy.aOB();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.dJq + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aOE()) {
                        runnable.run();
                    } else {
                        p.postOnComputation(runnable, "moveTaskToFront");
                    }
                }
            }
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            an.this.dJq = an.this.dJq && activity != null && activity.getTaskId() == an.this.dJs;
        }
    };
    private boolean dJq;
    private boolean dJr;
    private int dJs;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public interface a {
        void n(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        dJt = new a() { // from class: com.baidu.swan.apps.ap.an.2
            @Override // com.baidu.swan.apps.ap.an.a
            public void n(boolean z, int i) {
                if (z) {
                    an.this.dJq = true;
                    an.this.dJs = i;
                } else if (an.this.dJq && i == 1) {
                    an.this.dJq = false;
                }
                an.this.dJr = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.dJp);
    }

    public void onDestroy() {
        dJt = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.dJp);
    }

    public static void m(boolean z, int i) {
        if (dJt != null) {
            dJt.n(z, i);
        }
    }
}
