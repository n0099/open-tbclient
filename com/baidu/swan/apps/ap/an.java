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
/* loaded from: classes3.dex */
public class an {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a ddC;
    private boolean ddA;
    private int ddB;
    @Nullable
    private com.baidu.swan.apps.v.a ddy = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ap.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aEX()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ap.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r apG = com.baidu.swan.apps.t.a.apG();
                            ComponentName component = intent.getComponent();
                            if (an.this.ddz && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && apG != null && component != null && TextUtils.equals(apG.aap(), component.getClassName())) {
                                if (an.this.ddA) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aEW = b.aEW();
                                if (c.aFc() && b.aEY()) {
                                    c = aEW.b(activity, an.this.ddB, false);
                                } else {
                                    c = aEW.c(an.this.ddB, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.ddB);
                                }
                                aEW.aEZ();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.ddz + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aFc()) {
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
            an.this.ddz = an.this.ddz && activity != null && activity.getTaskId() == an.this.ddB;
        }
    };
    private boolean ddz;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        ddC = new a() { // from class: com.baidu.swan.apps.ap.an.2
            @Override // com.baidu.swan.apps.ap.an.a
            public void m(boolean z, int i) {
                if (z) {
                    an.this.ddz = true;
                    an.this.ddB = i;
                } else if (an.this.ddz && i == 1) {
                    an.this.ddz = false;
                }
                an.this.ddA = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.ddy);
    }

    public void onDestroy() {
        ddC = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.ddy);
    }

    public static void l(boolean z, int i) {
        if (ddC != null) {
            ddC.m(z, i);
        }
    }
}
