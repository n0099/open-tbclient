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
    private static a dNq;
    @Nullable
    private com.baidu.swan.apps.v.a dNm = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ao.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aMX()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ao.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r awK = com.baidu.swan.apps.t.a.awK();
                            ComponentName component = intent.getComponent();
                            if (an.this.dNn && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && awK != null && component != null && TextUtils.equals(awK.ahk(), component.getClassName())) {
                                if (an.this.dNo) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aMW = b.aMW();
                                if (c.aNc() && b.aMY()) {
                                    c = aMW.b(activity, an.this.dNp, false);
                                } else {
                                    c = aMW.c(an.this.dNp, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.dNp);
                                }
                                aMW.aMZ();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.dNn + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aNc()) {
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
            an.this.dNn = an.this.dNn && activity != null && activity.getTaskId() == an.this.dNp;
        }
    };
    private boolean dNn;
    private boolean dNo;
    private int dNp;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        dNq = new a() { // from class: com.baidu.swan.apps.ao.an.2
            @Override // com.baidu.swan.apps.ao.an.a
            public void m(boolean z, int i) {
                if (z) {
                    an.this.dNn = true;
                    an.this.dNp = i;
                } else if (an.this.dNn && i == 1) {
                    an.this.dNn = false;
                }
                an.this.dNo = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.dNm);
    }

    public void onDestroy() {
        dNq = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.dNm);
    }

    public static void l(boolean z, int i) {
        if (dNq != null) {
            dNq.m(z, i);
        }
    }
}
