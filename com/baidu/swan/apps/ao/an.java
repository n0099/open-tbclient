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
/* loaded from: classes8.dex */
public class an {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dQX;
    @Nullable
    private com.baidu.swan.apps.v.a dQT = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ao.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aNt()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ao.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r axl = com.baidu.swan.apps.t.a.axl();
                            ComponentName component = intent.getComponent();
                            if (an.this.dQU && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && axl != null && component != null && TextUtils.equals(axl.ahL(), component.getClassName())) {
                                if (an.this.dQV) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aNs = b.aNs();
                                if (c.aNy() && b.aNu()) {
                                    c = aNs.b(activity, an.this.dQW, false);
                                } else {
                                    c = aNs.c(an.this.dQW, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.dQW);
                                }
                                aNs.aNv();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.dQU + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aNy()) {
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
            an.this.dQU = an.this.dQU && activity != null && activity.getTaskId() == an.this.dQW;
        }
    };
    private boolean dQU;
    private boolean dQV;
    private int dQW;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        dQX = new a() { // from class: com.baidu.swan.apps.ao.an.2
            @Override // com.baidu.swan.apps.ao.an.a
            public void m(boolean z, int i) {
                if (z) {
                    an.this.dQU = true;
                    an.this.dQW = i;
                } else if (an.this.dQU && i == 1) {
                    an.this.dQU = false;
                }
                an.this.dQV = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.dQT);
    }

    public void onDestroy() {
        dQX = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.dQT);
    }

    public static void l(boolean z, int i) {
        if (dQX != null) {
            dQX.m(z, i);
        }
    }
}
