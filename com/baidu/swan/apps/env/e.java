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
    private c bui;
    private volatile boolean buj;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        static final e bun = new e();
    }

    private e() {
        this.buj = false;
        this.bui = new c(this);
        com.baidu.swan.apps.extcore.cores.a.RU().RV();
    }

    public static e RG() {
        return a.bun;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void p(Bundle bundle) {
        if (!this.buj) {
            synchronized (this) {
                if (!this.buj) {
                    q(bundle);
                    this.buj = true;
                }
            }
        }
    }

    public c RH() {
        return this.bui;
    }

    private void q(Bundle bundle) {
        r(bundle);
        SwanLauncher.RJ().initEnv();
        b.a.Lv();
    }

    private void r(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        j Uw = com.baidu.swan.apps.w.a.Uw();
        if (Uw != null) {
            final int Hc = Uw.Hc();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + Hc);
            }
            if (!Uw.Hd()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && Uw.He()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + Hc);
                    }
                    ai.b(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + Hc);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.w.a.Uw().Hf());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + Hc);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
