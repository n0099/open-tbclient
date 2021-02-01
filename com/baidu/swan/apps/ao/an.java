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
    private static a dPw;
    @Nullable
    private com.baidu.swan.apps.v.a dPs = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ao.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aNq()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ao.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r axi = com.baidu.swan.apps.t.a.axi();
                            ComponentName component = intent.getComponent();
                            if (an.this.dPt && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && axi != null && component != null && TextUtils.equals(axi.ahI(), component.getClassName())) {
                                if (an.this.dPu) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aNp = b.aNp();
                                if (c.aNv() && b.aNr()) {
                                    c = aNp.b(activity, an.this.dPv, false);
                                } else {
                                    c = aNp.c(an.this.dPv, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.dPv);
                                }
                                aNp.aNs();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.dPt + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aNv()) {
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
            an.this.dPt = an.this.dPt && activity != null && activity.getTaskId() == an.this.dPv;
        }
    };
    private boolean dPt;
    private boolean dPu;
    private int dPv;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        dPw = new a() { // from class: com.baidu.swan.apps.ao.an.2
            @Override // com.baidu.swan.apps.ao.an.a
            public void m(boolean z, int i) {
                if (z) {
                    an.this.dPt = true;
                    an.this.dPv = i;
                } else if (an.this.dPt && i == 1) {
                    an.this.dPt = false;
                }
                an.this.dPu = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.dPs);
    }

    public void onDestroy() {
        dPw = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.dPs);
    }

    public static void l(boolean z, int i) {
        if (dPw != null) {
            dPw.m(z, i);
        }
    }
}
