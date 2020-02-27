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
    private c btT;
    private volatile boolean btU;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        static final e btY = new e();
    }

    private e() {
        this.btU = false;
        this.btT = new c(this);
        com.baidu.swan.apps.extcore.cores.a.RP().RQ();
    }

    public static e RB() {
        return a.btY;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void p(Bundle bundle) {
        if (!this.btU) {
            synchronized (this) {
                if (!this.btU) {
                    q(bundle);
                    this.btU = true;
                }
            }
        }
    }

    public c RC() {
        return this.btT;
    }

    private void q(Bundle bundle) {
        r(bundle);
        SwanLauncher.RE().initEnv();
        b.a.Lq();
    }

    private void r(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        j Ur = com.baidu.swan.apps.w.a.Ur();
        if (Ur != null) {
            final int GV = Ur.GV();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + GV);
            }
            if (!Ur.GW()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && Ur.GX()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + GV);
                    }
                    ai.b(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + GV);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.w.a.Ur().GY());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + GV);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
