package com.baidu.swan.apps.env;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.adaptation.a.ak;
import com.baidu.swan.apps.adaptation.a.l;
import com.baidu.swan.apps.ao.ao;
import com.baidu.swan.apps.console.b;
import com.baidu.swan.apps.env.c;
import com.baidu.swan.apps.env.launch.SwanLauncher;
/* loaded from: classes8.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cXj;
    private volatile boolean cXk;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        static final e cXp = new e();
    }

    private e() {
        this.cXk = false;
        this.cXj = new c(this);
        com.baidu.swan.apps.extcore.cores.a.aub().auc();
    }

    public static e ath() {
        return a.cXp;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void q(Bundle bundle) {
        if (!this.cXk) {
            synchronized (this) {
                if (!this.cXk) {
                    r(bundle);
                    this.cXk = true;
                }
            }
        }
    }

    public c ati() {
        return this.cXj;
    }

    private void r(Bundle bundle) {
        s(bundle);
        SwanLauncher.atk().g(null);
        b.a.alo();
        ao.aOd();
        final ak axy = com.baidu.swan.apps.t.a.axy();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
            @Override // java.lang.Runnable
            public void run() {
                axy.aii();
            }
        }, "requestBatchRebateInfo", 2);
    }

    private void s(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        l awV = com.baidu.swan.apps.t.a.awV();
        if (awV != null) {
            final int afW = awV.afW();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + afW);
            }
            if (!awV.afX()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && awV.afY()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + afW);
                    }
                    com.baidu.swan.apps.ao.ak.c(new Runnable() { // from class: com.baidu.swan.apps.env.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + afW);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.t.a.awV().afZ());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + afW);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
