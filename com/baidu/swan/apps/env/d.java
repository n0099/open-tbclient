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
    private b awa;
    private volatile boolean awb;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        static final d awf = new d();
    }

    private d() {
        this.awb = false;
        this.awa = new b(this);
        com.baidu.swan.apps.extcore.cores.a.CY().CZ();
    }

    public static d CP() {
        return a.awf;
    }

    @NonNull
    public Context CQ() {
        return AppRuntime.getAppContext();
    }

    public void l(Bundle bundle) {
        if (!this.awb) {
            synchronized (this) {
                if (!this.awb) {
                    m(bundle);
                    this.awb = true;
                }
            }
        }
    }

    public b CR() {
        return this.awa;
    }

    private void m(Bundle bundle) {
        n(bundle);
    }

    private void n(Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        com.baidu.swan.apps.b.b.e EG = com.baidu.swan.apps.u.a.EG();
        if (EG != null) {
            final int wH = EG.wH();
            if (DEBUG) {
                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess switch: " + wH);
            }
            if (!EG.wI()) {
                String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
                if (TextUtils.isEmpty(string)) {
                    string = "0";
                }
                final Bundle bundle2 = new Bundle();
                bundle2.putString("bundle_key_preload_preload_scene", string);
                if (EG.wJ()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - start. switch: " + wH);
                    }
                    ac.c(new Runnable() { // from class: com.baidu.swan.apps.env.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - run. switch: " + wH);
                            }
                            com.baidu.swan.apps.process.messaging.service.c.b(d.this.CQ(), bundle2);
                        }
                    }, com.baidu.swan.apps.u.a.EG().wK());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess start. switch: " + wH);
                }
                com.baidu.swan.apps.process.messaging.service.c.b(CQ(), bundle2);
            }
        }
    }
}
