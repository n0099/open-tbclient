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
    private b avv;
    private volatile boolean avw;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        static final d avA = new d();
    }

    private d() {
        this.avw = false;
        this.avv = new b(this);
        com.baidu.swan.apps.extcore.cores.a.Cp().Cq();
    }

    public static d Cg() {
        return a.avA;
    }

    @NonNull
    public Context Ch() {
        return AppRuntime.getAppContext();
    }

    public void l(Bundle bundle) {
        if (!this.avw) {
            synchronized (this) {
                if (!this.avw) {
                    m(bundle);
                    this.avw = true;
                }
            }
        }
    }

    public b Ci() {
        return this.avv;
    }

    private void m(Bundle bundle) {
        n(bundle);
    }

    private void n(Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        com.baidu.swan.apps.b.b.e DX = com.baidu.swan.apps.u.a.DX();
        if (DX != null) {
            final int wg = DX.wg();
            if (DEBUG) {
                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess switch: " + wg);
            }
            if (!DX.wh()) {
                String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
                if (TextUtils.isEmpty(string)) {
                    string = "0";
                }
                final Bundle bundle2 = new Bundle();
                bundle2.putString("bundle_key_preload_preload_scene", string);
                if (DX.wi()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - start. switch: " + wg);
                    }
                    ac.c(new Runnable() { // from class: com.baidu.swan.apps.env.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - run. switch: " + wg);
                            }
                            com.baidu.swan.apps.process.messaging.service.c.b(d.this.Ch(), bundle2);
                        }
                    }, com.baidu.swan.apps.u.a.DX().wj());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess start. switch: " + wg);
                }
                com.baidu.swan.apps.process.messaging.service.c.b(Ch(), bundle2);
            }
        }
    }
}
