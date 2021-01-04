package com.baidu.swan.apps.ao;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class an {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dSc;
    @Nullable
    private com.baidu.swan.apps.v.a dRY = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ao.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aQQ()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ao.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r aAD = com.baidu.swan.apps.t.a.aAD();
                            ComponentName component = intent.getComponent();
                            if (an.this.dRZ && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && aAD != null && component != null && TextUtils.equals(aAD.ald(), component.getClassName())) {
                                if (an.this.dSa) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aQP = b.aQP();
                                if (c.aQV() && b.aQR()) {
                                    c = aQP.b(activity, an.this.dSb, false);
                                } else {
                                    c = aQP.c(an.this.dSb, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.dSb);
                                }
                                aQP.aQS();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.dRZ + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aQV()) {
                        runnable.run();
                    } else {
                        p.b(runnable, "moveTaskToFront");
                    }
                }
            }
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            an.this.dRZ = an.this.dRZ && activity != null && activity.getTaskId() == an.this.dSb;
        }
    };
    private boolean dRZ;
    private boolean dSa;
    private int dSb;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        dSc = new a() { // from class: com.baidu.swan.apps.ao.an.2
            @Override // com.baidu.swan.apps.ao.an.a
            public void m(boolean z, int i) {
                if (z) {
                    an.this.dRZ = true;
                    an.this.dSb = i;
                } else if (an.this.dRZ && i == 1) {
                    an.this.dRZ = false;
                }
                an.this.dSa = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.dRY);
    }

    public void onDestroy() {
        dSc = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.dRY);
    }

    public static void l(boolean z, int i) {
        if (dSc != null) {
            dSc.m(z, i);
        }
    }
}
