package com.baidu.swan.apps.env;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.k;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.am;
import com.baidu.swan.apps.console.b;
import com.baidu.swan.apps.env.c;
import com.baidu.swan.apps.env.launch.SwanLauncher;
/* loaded from: classes11.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cck;
    private volatile boolean ccl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        static final e ccp = new e();
    }

    private e() {
        this.ccl = false;
        this.cck = new c(this);
        com.baidu.swan.apps.extcore.cores.a.acI().acJ();
    }

    public static e acv() {
        return a.ccp;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void s(Bundle bundle) {
        if (!this.ccl) {
            synchronized (this) {
                if (!this.ccl) {
                    t(bundle);
                    this.ccl = true;
                }
            }
        }
    }

    public c acw() {
        return this.cck;
    }

    private void t(Bundle bundle) {
        u(bundle);
        SwanLauncher.acy().e(null);
        b.a.VP();
        am.atV();
        com.baidu.swan.apps.u.a.afP().So();
    }

    private void u(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        k afn = com.baidu.swan.apps.u.a.afn();
        if (afn != null) {
            final int Ra = afn.Ra();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + Ra);
            }
            if (!afn.Rb()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && afn.Rc()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + Ra);
                    }
                    aj.c(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + Ra);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.u.a.afn().Rd());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + Ra);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
