package com.baidu.swan.apps.env;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.env.b;
/* loaded from: classes2.dex */
public final class d implements b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b aPN;
    private volatile boolean aPO;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        static final d aPS = new d();
    }

    private d() {
        this.aPO = false;
        this.aPN = new b(this);
        com.baidu.swan.apps.extcore.cores.a.HW().HX();
    }

    public static d HN() {
        return a.aPS;
    }

    @NonNull
    public Context HO() {
        return AppRuntime.getAppContext();
    }

    public void l(Bundle bundle) {
        if (!this.aPO) {
            synchronized (this) {
                if (!this.aPO) {
                    m(bundle);
                    this.aPO = true;
                }
            }
        }
    }

    public b HP() {
        return this.aPN;
    }

    private void m(Bundle bundle) {
        n(bundle);
    }

    private void n(Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        com.baidu.swan.apps.b.b.e JE = com.baidu.swan.apps.u.a.JE();
        if (JE != null) {
            final int BF = JE.BF();
            if (DEBUG) {
                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess switch: " + BF);
            }
            if (!JE.BG()) {
                String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
                if (TextUtils.isEmpty(string)) {
                    string = "0";
                }
                final Bundle bundle2 = new Bundle();
                bundle2.putString("bundle_key_preload_preload_scene", string);
                if (JE.BH()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - start. switch: " + BF);
                    }
                    ac.c(new Runnable() { // from class: com.baidu.swan.apps.env.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - run. switch: " + BF);
                            }
                            com.baidu.swan.apps.process.messaging.service.c.b(d.this.HO(), bundle2);
                        }
                    }, com.baidu.swan.apps.u.a.JE().BI());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess start. switch: " + BF);
                }
                com.baidu.swan.apps.process.messaging.service.c.b(HO(), bundle2);
            }
        }
    }
}
