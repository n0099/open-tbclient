package com.baidu.swan.apps.env;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.j;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.console.b;
import com.baidu.swan.apps.env.c;
import com.baidu.swan.apps.env.launch.SwanLauncher;
/* loaded from: classes11.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c btU;
    private volatile boolean btV;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        static final e btZ = new e();
    }

    private e() {
        this.btV = false;
        this.btU = new c(this);
        com.baidu.swan.apps.extcore.cores.a.RR().RS();
    }

    public static e RD() {
        return a.btZ;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void p(Bundle bundle) {
        if (!this.btV) {
            synchronized (this) {
                if (!this.btV) {
                    q(bundle);
                    this.btV = true;
                }
            }
        }
    }

    public c RE() {
        return this.btU;
    }

    private void q(Bundle bundle) {
        r(bundle);
        SwanLauncher.RG().initEnv();
        b.a.Ls();
    }

    private void r(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        j Ut = com.baidu.swan.apps.w.a.Ut();
        if (Ut != null) {
            final int GX = Ut.GX();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + GX);
            }
            if (!Ut.GY()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && Ut.GZ()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + GX);
                    }
                    ai.b(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + GX);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.w.a.Ut().Ha());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + GX);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
