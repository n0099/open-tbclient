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
/* loaded from: classes8.dex */
public class an {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dbw;
    @Nullable
    private com.baidu.swan.apps.v.a dbs = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.ap.an.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.aEn()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.ap.an.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean c;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.r aoV = com.baidu.swan.apps.t.a.aoV();
                            ComponentName component = intent.getComponent();
                            if (an.this.dbt && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && aoV != null && component != null && TextUtils.equals(aoV.ZG(), component.getClassName())) {
                                if (an.this.dbu) {
                                    if (an.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b aEm = b.aEm();
                                if (c.aEs() && b.aEo()) {
                                    c = aEm.b(activity, an.this.dbv, false);
                                } else {
                                    c = aEm.c(an.this.dbv, false, false);
                                }
                                if (an.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + c + ", taskId=" + an.this.dbv);
                                }
                                aEm.aEp();
                            }
                            if (an.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + an.this.dbt + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.aEs()) {
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
            an.this.dbt = an.this.dbt && activity != null && activity.getTaskId() == an.this.dbv;
        }
    };
    private boolean dbt;
    private boolean dbu;
    private int dbv;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public an(@NonNull Application application) {
        this.mApp = application;
        dbw = new a() { // from class: com.baidu.swan.apps.ap.an.2
            @Override // com.baidu.swan.apps.ap.an.a
            public void m(boolean z, int i) {
                if (z) {
                    an.this.dbt = true;
                    an.this.dbv = i;
                } else if (an.this.dbt && i == 1) {
                    an.this.dbt = false;
                }
                an.this.dbu = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.dbs);
    }

    public void onDestroy() {
        dbw = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.dbs);
    }

    public static void l(boolean z, int i) {
        if (dbw != null) {
            dbw.m(z, i);
        }
    }
}
