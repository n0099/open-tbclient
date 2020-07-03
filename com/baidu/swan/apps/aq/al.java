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
    private static a cOY;
    @Nullable
    private com.baidu.swan.apps.w.a cOV = new com.baidu.swan.apps.w.a() { // from class: com.baidu.swan.apps.aq.al.1
        @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (com.baidu.swan.apps.aq.a.aud()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Intent intent = activity.getIntent();
                    com.baidu.swan.apps.adaptation.a.q agj = com.baidu.swan.apps.u.a.agj();
                    ComponentName component = intent.getComponent();
                    if (al.this.cOW && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && agj != null && component != null && TextUtils.equals(agj.Tl(), component.getClassName())) {
                        com.baidu.swan.apps.aq.a auc = com.baidu.swan.apps.aq.a.auc();
                        boolean y = auc.y(al.this.cOX, false);
                        if (al.DEBUG) {
                            Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + y + ", taskId=" + al.this.cOX);
                        }
                        auc.aue();
                    }
                    if (al.DEBUG) {
                        Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + al.this.cOW + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                    }
                }
            }
        }

        @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            super.onActivityStarted(activity);
            if (!al.this.cOW || activity == null || activity.getTaskId() != al.this.cOX) {
                al.this.cOW = false;
            } else {
                al.this.cOW = true;
            }
        }
    };
    private boolean cOW;
    private int cOX;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public al(@NonNull Application application) {
        this.mApp = application;
        cOY = new a() { // from class: com.baidu.swan.apps.aq.al.2
            @Override // com.baidu.swan.apps.aq.al.a
            public void m(boolean z, int i) {
                if (z) {
                    al.this.cOW = true;
                    al.this.cOX = i;
                }
            }
        };
        application.registerActivityLifecycleCallbacks(this.cOV);
    }

    public void onDestroy() {
        cOY = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.cOV);
    }

    public static void l(boolean z, int i) {
        if (cOY != null) {
            cOY.m(z, i);
        }
    }
}
