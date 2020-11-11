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
    private static a dEc;
    @Nullable
    private com.baidu.swan.apps.v.a dDY = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ap.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aMa()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ap.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r awM = com.baidu.swan.apps.t.a.awM();
                            ComponentName component = intent.getComponent();
                            if (an.this.dDZ && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && awM != null && component != null && TextUtils.equals(awM.ahv(), component.getClassName())) {
                                if (an.this.dEa) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aLZ = b.aLZ();
                                if (c.aMf() && b.aMb()) {
                                    c = aLZ.b(activity, an.this.dEb, false);
                                } else {
                                    c = aLZ.c(an.this.dEb, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.dEb);
                                }
                                aLZ.aMc();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.dDZ + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aMf()) {
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
            an.this.dDZ = an.this.dDZ && activity != null && activity.getTaskId() == an.this.dEb;
        }
    };
    private boolean dDZ;
    private boolean dEa;
    private int dEb;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void n(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        dEc = new a() { // from class: com.baidu.swan.apps.ap.an.2
            @Override // com.baidu.swan.apps.ap.an.a
            public void n(boolean z, int i) {
                if (z) {
                    an.this.dDZ = true;
                    an.this.dEb = i;
                } else if (an.this.dDZ && i == 1) {
                    an.this.dDZ = false;
                }
                an.this.dEa = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.dDY);
    }

    public void onDestroy() {
        dEc = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.dDY);
    }

    public static void m(boolean z, int i) {
        if (dEc != null) {
            dEc.n(z, i);
        }
    }
}
