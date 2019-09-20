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
    private b awy;
    private volatile boolean awz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        static final d awD = new d();
    }

    private d() {
        this.awz = false;
        this.awy = new b(this);
        com.baidu.swan.apps.extcore.cores.a.Dc().Dd();
    }

    public static d CT() {
        return a.awD;
    }

    @NonNull
    public Context CU() {
        return AppRuntime.getAppContext();
    }

    public void l(Bundle bundle) {
        if (!this.awz) {
            synchronized (this) {
                if (!this.awz) {
                    m(bundle);
                    this.awz = true;
                }
            }
        }
    }

    public b CV() {
        return this.awy;
    }

    private void m(Bundle bundle) {
        n(bundle);
    }

    private void n(Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        com.baidu.swan.apps.b.b.e EK = com.baidu.swan.apps.u.a.EK();
        if (EK != null) {
            final int wL = EK.wL();
            if (DEBUG) {
                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess switch: " + wL);
            }
            if (!EK.wM()) {
                String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
                if (TextUtils.isEmpty(string)) {
                    string = "0";
                }
                final Bundle bundle2 = new Bundle();
                bundle2.putString("bundle_key_preload_preload_scene", string);
                if (EK.wN()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - start. switch: " + wL);
                    }
                    ac.c(new Runnable() { // from class: com.baidu.swan.apps.env.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - run. switch: " + wL);
                            }
                            com.baidu.swan.apps.process.messaging.service.c.b(d.this.CU(), bundle2);
                        }
                    }, com.baidu.swan.apps.u.a.EK().wO());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess start. switch: " + wL);
                }
                com.baidu.swan.apps.process.messaging.service.c.b(CU(), bundle2);
            }
        }
    }
}
