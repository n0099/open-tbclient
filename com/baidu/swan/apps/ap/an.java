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
/* loaded from: classes10.dex */
public class an {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dpK;
    @Nullable
    private com.baidu.swan.apps.v.a dpG = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ap.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aHG()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ap.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r ass = com.baidu.swan.apps.t.a.ass();
                            ComponentName component = intent.getComponent();
                            if (an.this.dpH && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && ass != null && component != null && TextUtils.equals(ass.adb(), component.getClassName())) {
                                if (an.this.dpI) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aHF = b.aHF();
                                if (c.aHL() && b.aHH()) {
                                    c = aHF.b(activity, an.this.dpJ, false);
                                } else {
                                    c = aHF.c(an.this.dpJ, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.dpJ);
                                }
                                aHF.aHI();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.dpH + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aHL()) {
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
            an.this.dpH = an.this.dpH && activity != null && activity.getTaskId() == an.this.dpJ;
        }
    };
    private boolean dpH;
    private boolean dpI;
    private int dpJ;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void n(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        dpK = new a() { // from class: com.baidu.swan.apps.ap.an.2
            @Override // com.baidu.swan.apps.ap.an.a
            public void n(boolean z, int i) {
                if (z) {
                    an.this.dpH = true;
                    an.this.dpJ = i;
                } else if (an.this.dpH && i == 1) {
                    an.this.dpH = false;
                }
                an.this.dpI = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.dpG);
    }

    public void onDestroy() {
        dpK = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.dpG);
    }

    public static void m(boolean z, int i) {
        if (dpK != null) {
            dpK.n(z, i);
        }
    }
}
