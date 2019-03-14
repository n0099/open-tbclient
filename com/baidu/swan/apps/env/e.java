package com.baidu.swan.apps.env;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.env.c;
/* loaded from: classes2.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c auZ;
    private volatile boolean ava;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        static final e ave = new e();
    }

    private e() {
        this.ava = false;
        this.auZ = new c(this);
        com.baidu.swan.apps.extcore.cores.a.Bo().Bp();
    }

    public static e Bf() {
        return a.ave;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context AZ() {
        return AppRuntime.getAppContext();
    }

    public void l(Bundle bundle) {
        if (!this.ava) {
            synchronized (this) {
                if (!this.ava) {
                    m(bundle);
                    this.ava = true;
                }
            }
        }
    }

    public c Bg() {
        return this.auZ;
    }

    private void m(Bundle bundle) {
        n(bundle);
    }

    private void n(Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        com.baidu.swan.apps.b.b.e CU = com.baidu.swan.apps.u.a.CU();
        if (CU != null) {
            final int vs = CU.vs();
            if (DEBUG) {
                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess switch: " + vs);
            }
            if (!CU.vt()) {
                String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
                if (TextUtils.isEmpty(string)) {
                    string = "0";
                }
                final Bundle bundle2 = new Bundle();
                bundle2.putString("bundle_key_preload_preload_scene", string);
                if (CU.vu()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - start. switch: " + vs);
                    }
                    aa.b(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - run. switch: " + vs);
                            }
                            com.baidu.swan.apps.process.messaging.service.c.c(e.this.AZ(), bundle2);
                        }
                    }, com.baidu.swan.apps.u.a.CU().vv());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess start. switch: " + vs);
                }
                com.baidu.swan.apps.process.messaging.service.c.c(AZ(), bundle2);
            }
        }
    }
}
