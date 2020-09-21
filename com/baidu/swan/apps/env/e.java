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
/* loaded from: classes3.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c crs;
    private volatile boolean crt;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        static final e cry = new e();
    }

    private e() {
        this.crt = false;
        this.crs = new c(this);
        com.baidu.swan.apps.extcore.cores.a.amV().amW();
    }

    public static e amb() {
        return a.cry;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void q(Bundle bundle) {
        if (!this.crt) {
            synchronized (this) {
                if (!this.crt) {
                    r(bundle);
                    this.crt = true;
                }
            }
        }
    }

    public c amc() {
        return this.crs;
    }

    private void r(Bundle bundle) {
        s(bundle);
        SwanLauncher.ame().g(null);
        b.a.aer();
        ao.aGd();
        final ak aqu = com.baidu.swan.apps.t.a.aqu();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
            @Override // java.lang.Runnable
            public void run() {
                aqu.abl();
            }
        }, "requestBatchRebateInfo", 2);
    }

    private void s(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        l apR = com.baidu.swan.apps.t.a.apR();
        if (apR != null) {
            final int Zb = apR.Zb();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + Zb);
            }
            if (!apR.Zc()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && apR.Zd()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + Zb);
                    }
                    com.baidu.swan.apps.ap.ak.c(new Runnable() { // from class: com.baidu.swan.apps.env.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + Zb);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.t.a.apR().Ze());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + Zb);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
