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
/* loaded from: classes7.dex */
public class ao {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cSx;
    @Nullable
    private com.baidu.swan.apps.v.a cSt = new com.baidu.swan.apps.v.a() { // from class: com.baidu.swan.apps.aq.ao.1
        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(final Activity activity, Bundle bundle) {
            if (b.awe()) {
                super.onActivityCreated(activity, bundle);
                if (activity != null && activity.getIntent() != null) {
                    Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.aq.ao.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean x;
                            Intent intent = activity.getIntent();
                            com.baidu.swan.apps.adaptation.a.q ahv = com.baidu.swan.apps.t.a.ahv();
                            ComponentName component = intent.getComponent();
                            if (ao.this.cSu && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && ahv != null && component != null && TextUtils.equals(ahv.TG(), component.getClassName())) {
                                if (ao.this.cSv) {
                                    if (ao.DEBUG) {
                                        Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                        return;
                                    }
                                    return;
                                }
                                b awd = b.awd();
                                if (c.awi() && b.awf()) {
                                    x = awd.b(activity, ao.this.cSw, false);
                                } else {
                                    x = awd.x(ao.this.cSw, false);
                                }
                                if (ao.DEBUG) {
                                    Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + x + ", taskId=" + ao.this.cSw);
                                }
                                awd.awg();
                            }
                            if (ao.DEBUG) {
                                Log.d("SwanHomeScreenLaunch", "class=" + activity + ", swanAppForeground=" + ao.this.cSu + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                            }
                        }
                    };
                    if (c.awi()) {
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
            ao.this.cSu = ao.this.cSu && activity != null && activity.getTaskId() == ao.this.cSw;
        }
    };
    private boolean cSu;
    private boolean cSv;
    private int cSw;
    @NonNull
    private final Application mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void m(boolean z, int i);
    }

    public ao(@NonNull Application application) {
        this.mApp = application;
        cSx = new a() { // from class: com.baidu.swan.apps.aq.ao.2
            @Override // com.baidu.swan.apps.aq.ao.a
            public void m(boolean z, int i) {
                if (z) {
                    ao.this.cSu = true;
                    ao.this.cSw = i;
                } else if (ao.this.cSu && i == 1) {
                    ao.this.cSu = false;
                }
                ao.this.cSv = z;
            }
        };
        application.registerActivityLifecycleCallbacks(this.cSt);
    }

    public void onDestroy() {
        cSx = null;
        this.mApp.unregisterActivityLifecycleCallbacks(this.cSt);
    }

    public static void l(boolean z, int i) {
        if (cSx != null) {
            cSx.m(z, i);
        }
    }
}
