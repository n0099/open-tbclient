package com.baidu.swan.apps.env;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.adaptation.a.ag;
import com.baidu.swan.apps.adaptation.a.k;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.ap;
import com.baidu.swan.apps.console.b;
import com.baidu.swan.apps.env.c;
import com.baidu.swan.apps.env.launch.SwanLauncher;
/* loaded from: classes7.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c ciN;
    private volatile boolean ciO;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        static final e ciT = new e();
    }

    private e() {
        this.ciO = false;
        this.ciN = new c(this);
        com.baidu.swan.apps.extcore.cores.a.afe().aff();
    }

    public static e aeI() {
        return a.ciT;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void s(Bundle bundle) {
        if (!this.ciO) {
            synchronized (this) {
                if (!this.ciO) {
                    t(bundle);
                    this.ciO = true;
                }
            }
        }
    }

    public c aeJ() {
        return this.ciN;
    }

    private void t(Bundle bundle) {
        u(bundle);
        SwanLauncher.aeL().f(null);
        b.a.XB();
        ap.axk();
        final ag aii = com.baidu.swan.apps.t.a.aii();
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
                @Override // java.lang.Runnable
                public void run() {
                    aii.UA();
                }
            }, "requestBatchRebateInfo", 2);
        } else {
            aii.UA();
        }
    }

    private void u(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        k ahG = com.baidu.swan.apps.t.a.ahG();
        if (ahG != null) {
            final int Sx = ahG.Sx();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + Sx);
            }
            if (!ahG.Sy()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && ahG.Sz()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + Sx);
                    }
                    al.c(new Runnable() { // from class: com.baidu.swan.apps.env.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + Sx);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.t.a.ahG().SA());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + Sx);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
