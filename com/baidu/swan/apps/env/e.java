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
/* loaded from: classes8.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cpk;
    private volatile boolean cpl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        static final e cpq = new e();
    }

    private e() {
        this.cpl = false;
        this.cpk = new c(this);
        com.baidu.swan.apps.extcore.cores.a.aml().amm();
    }

    public static e alr() {
        return a.cpq;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void q(Bundle bundle) {
        if (!this.cpl) {
            synchronized (this) {
                if (!this.cpl) {
                    r(bundle);
                    this.cpl = true;
                }
            }
        }
    }

    public c als() {
        return this.cpk;
    }

    private void r(Bundle bundle) {
        s(bundle);
        SwanLauncher.alu().g(null);
        b.a.adH();
        ao.aFt();
        final ak apK = com.baidu.swan.apps.t.a.apK();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
            @Override // java.lang.Runnable
            public void run() {
                apK.aaC();
            }
        }, "requestBatchRebateInfo", 2);
    }

    private void s(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        l apg = com.baidu.swan.apps.t.a.apg();
        if (apg != null) {
            final int Ys = apg.Ys();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + Ys);
            }
            if (!apg.Yt()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && apg.Yu()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + Ys);
                    }
                    com.baidu.swan.apps.ap.ak.c(new Runnable() { // from class: com.baidu.swan.apps.env.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + Ys);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.t.a.apg().Yv());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + Ys);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
