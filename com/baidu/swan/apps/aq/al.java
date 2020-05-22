package com.baidu.swan.apps.aq;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes11.dex */
public class al {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cKo;
    @Nullable
    private com.baidu.swan.apps.w.a cKl = new com.baidu.swan.apps.w.a() { // from class: com.baidu.swan.apps.aq.al.1
        @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (com.baidu.swan.apps.aq.a.asX()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Intent intent = activity.getIntent();
                    com.baidu.swan.apps.adaptation.a.q afd = com.baidu.swan.apps.u.a.afd();
                    ComponentName component = intent.getComponent();
                    if (al.this.cKm && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && afd != null && component != null && TextUtils.equals(afd.Sf(), component.getClassName())) {
                        com.baidu.swan.apps.aq.a asW = com.baidu.swan.apps.aq.a.asW();
                        boolean x = asW.x(al.this.cKn, false);
                        if (al.DEBUG) {
                            Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + x + ", taskId=" + al.this.cKn);
                        }
                        asW.asY();
                    }
                    if (al.DEBUG) {
                        Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + al.this.cKm + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                    }
                }
            }
        }

        @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            if (!al.this.cKm || activity == null || activity.getTaskId() != al.this.cKn) {
                al.this.cKm = false;
            } else {
                al.this.cKm = true;
            }
        }
    };
    private boolean cKm;
    private int cKn;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public al(@NonNull Application application) {
        this.mApp = application;
        cKo = new a() { // from class: com.baidu.swan.apps.aq.al.2
            @Override // com.baidu.swan.apps.aq.al.a
            public void m(boolean z, int i) {
                if (z) {
                    al.this.cKm = true;
                    al.this.cKn = i;
                }
            }
        };
        application.registerActivityLifecycleCallbacks(this.cKl);
    }

    public void onDestroy() {
        cKo = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.cKl);
    }

    public static void l(boolean z, int i) {
        if (cKo != null) {
            cKo.m(z, i);
        }
    }
}
