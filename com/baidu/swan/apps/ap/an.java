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
    private static a dyk;
    @Nullable
    private com.baidu.swan.apps.v.a dyg = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ap.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aJA()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ap.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r aum = com.baidu.swan.apps.t.a.aum();
                            ComponentName component = intent.getComponent();
                            if (an.this.dyh && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && aum != null && component != null && TextUtils.equals(aum.aeV(), component.getClassName())) {
                                if (an.this.dyi) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aJz = b.aJz();
                                if (c.aJF() && b.aJB()) {
                                    c = aJz.b(activity, an.this.dyj, false);
                                } else {
                                    c = aJz.c(an.this.dyj, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.dyj);
                                }
                                aJz.aJC();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.dyh + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aJF()) {
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
            an.this.dyh = an.this.dyh && activity != null && activity.getTaskId() == an.this.dyj;
        }
    };
    private boolean dyh;
    private boolean dyi;
    private int dyj;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void n(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        dyk = new a() { // from class: com.baidu.swan.apps.ap.an.2
            @Override // com.baidu.swan.apps.ap.an.a
            public void n(boolean z, int i) {
                if (z) {
                    an.this.dyh = true;
                    an.this.dyj = i;
                } else if (an.this.dyh && i == 1) {
                    an.this.dyh = false;
                }
                an.this.dyi = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.dyg);
    }

    public void onDestroy() {
        dyk = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.dyg);
    }

    public static void m(boolean z, int i) {
        if (dyk != null) {
            dyk.n(z, i);
        }
    }
}
