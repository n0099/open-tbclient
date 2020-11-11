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
/* loaded from: classes10.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cRT;
    private volatile boolean cRU;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        static final e cRZ = new e();
    }

    private e() {
        this.cRU = false;
        this.cRT = new c(this);
        com.baidu.swan.apps.extcore.cores.a.auc().aud();
    }

    public static e ati() {
        return a.cRZ;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void q(Bundle bundle) {
        if (!this.cRU) {
            synchronized (this) {
                if (!this.cRU) {
                    r(bundle);
                    this.cRU = true;
                }
            }
        }
    }

    public c atj() {
        return this.cRT;
    }

    private void r(Bundle bundle) {
        s(bundle);
        SwanLauncher.atl().g(null);
        b.a.alw();
        ao.aNg();
        final ak axA = com.baidu.swan.apps.t.a.axA();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
            @Override // java.lang.Runnable
            public void run() {
                axA.air();
            }
        }, "requestBatchRebateInfo", 2);
    }

    private void s(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        l awX = com.baidu.swan.apps.t.a.awX();
        if (awX != null) {
            final int agh = awX.agh();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + agh);
            }
            if (!awX.agi()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && awX.agj()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + agh);
                    }
                    com.baidu.swan.apps.ap.ak.c(new Runnable() { // from class: com.baidu.swan.apps.env.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + agh);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.t.a.awX().agk());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + agh);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
