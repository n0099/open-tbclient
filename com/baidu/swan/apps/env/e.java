package com.baidu.swan.apps.env;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.adaptation.a.ak;
import com.baidu.swan.apps.adaptation.a.l;
import com.baidu.swan.apps.ap.ao;
import com.baidu.swan.apps.console.b;
import com.baidu.swan.apps.env.c;
import com.baidu.swan.apps.env.launch.SwanLauncher;
/* loaded from: classes25.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cXc;
    private volatile boolean cXd;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a {
        static final e cXi = new e();
    }

    private e() {
        this.cXd = false;
        this.cXc = new c(this);
        com.baidu.swan.apps.extcore.cores.a.awC().awD();
    }

    public static e avI() {
        return a.cXi;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void q(Bundle bundle) {
        if (!this.cXd) {
            synchronized (this) {
                if (!this.cXd) {
                    r(bundle);
                    this.cXd = true;
                }
            }
        }
    }

    public c avJ() {
        return this.cXc;
    }

    private void r(Bundle bundle) {
        s(bundle);
        SwanLauncher.avL().g(null);
        b.a.anW();
        ao.aPE();
        final ak aAa = com.baidu.swan.apps.t.a.aAa();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
            @Override // java.lang.Runnable
            public void run() {
                aAa.akR();
            }
        }, "requestBatchRebateInfo", 2);
    }

    private void s(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        l azx = com.baidu.swan.apps.t.a.azx();
        if (azx != null) {
            final int aiH = azx.aiH();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + aiH);
            }
            if (!azx.aiI()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && azx.aiJ()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + aiH);
                    }
                    com.baidu.swan.apps.ap.ak.c(new Runnable() { // from class: com.baidu.swan.apps.env.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + aiH);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.t.a.azx().aiK());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + aiH);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
