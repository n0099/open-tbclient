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
    private b aPv;
    private volatile boolean aPw;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        static final d aPA = new d();
    }

    private d() {
        this.aPw = false;
        this.aPv = new b(this);
        com.baidu.swan.apps.extcore.cores.a.HX().HY();
    }

    public static d HO() {
        return a.aPA;
    }

    @NonNull
    public Context HP() {
        return AppRuntime.getAppContext();
    }

    public void l(Bundle bundle) {
        if (!this.aPw) {
            synchronized (this) {
                if (!this.aPw) {
                    m(bundle);
                    this.aPw = true;
                }
            }
        }
    }

    public b HQ() {
        return this.aPv;
    }

    private void m(Bundle bundle) {
        n(bundle);
    }

    private void n(Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        com.baidu.swan.apps.b.b.e JF = com.baidu.swan.apps.u.a.JF();
        if (JF != null) {
            final int BG = JF.BG();
            if (DEBUG) {
                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess switch: " + BG);
            }
            if (!JF.BH()) {
                String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
                if (TextUtils.isEmpty(string)) {
                    string = "0";
                }
                final Bundle bundle2 = new Bundle();
                bundle2.putString("bundle_key_preload_preload_scene", string);
                if (JF.BI()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - start. switch: " + BG);
                    }
                    ac.c(new Runnable() { // from class: com.baidu.swan.apps.env.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - run. switch: " + BG);
                            }
                            com.baidu.swan.apps.process.messaging.service.c.b(d.this.HP(), bundle2);
                        }
                    }, com.baidu.swan.apps.u.a.JF().BJ());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess start. switch: " + BG);
                }
                com.baidu.swan.apps.process.messaging.service.c.b(HP(), bundle2);
            }
        }
    }
}
