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
/* loaded from: classes7.dex */
public class an {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dCv;
    @Nullable
    private com.baidu.swan.apps.v.a dCr = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ap.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aLs()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ap.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r awe = com.baidu.swan.apps.t.a.awe();
                            ComponentName component = intent.getComponent();
                            if (an.this.dCs && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && awe != null && component != null && TextUtils.equals(awe.agN(), component.getClassName())) {
                                if (an.this.dCt) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aLr = b.aLr();
                                if (c.aLx() && b.aLt()) {
                                    c = aLr.b(activity, an.this.dCu, false);
                                } else {
                                    c = aLr.c(an.this.dCu, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.dCu);
                                }
                                aLr.aLu();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.dCs + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aLx()) {
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
            an.this.dCs = an.this.dCs && activity != null && activity.getTaskId() == an.this.dCu;
        }
    };
    private boolean dCs;
    private boolean dCt;
    private int dCu;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void n(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        dCv = new a() { // from class: com.baidu.swan.apps.ap.an.2
            @Override // com.baidu.swan.apps.ap.an.a
            public void n(boolean z, int i) {
                if (z) {
                    an.this.dCs = true;
                    an.this.dCu = i;
                } else if (an.this.dCs && i == 1) {
                    an.this.dCs = false;
                }
                an.this.dCt = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.dCr);
    }

    public void onDestroy() {
        dCv = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.dCr);
    }

    public static void m(boolean z, int i) {
        if (dCv != null) {
            dCv.n(z, i);
        }
    }
}
