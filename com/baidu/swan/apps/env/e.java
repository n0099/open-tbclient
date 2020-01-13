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
/* loaded from: classes10.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c bpK;
    private volatile boolean bpL;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        static final e bpP = new e();
    }

    private e() {
        this.bpL = false;
        this.bpK = new c(this);
        com.baidu.swan.apps.extcore.cores.a.PB().PC();
    }

    public static e Pn() {
        return a.bpP;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void p(Bundle bundle) {
        if (!this.bpL) {
            synchronized (this) {
                if (!this.bpL) {
                    q(bundle);
                    this.bpL = true;
                }
            }
        }
    }

    public c Po() {
        return this.bpK;
    }

    private void q(Bundle bundle) {
        r(bundle);
        SwanLauncher.Pq().initEnv();
        b.a.Jb();
    }

    private void r(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        j Sd = com.baidu.swan.apps.w.a.Sd();
        if (Sd != null) {
            final int EG = Sd.EG();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + EG);
            }
            if (!Sd.EH()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && Sd.EI()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + EG);
                    }
                    ai.b(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + EG);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.w.a.Sd().EJ());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + EG);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
