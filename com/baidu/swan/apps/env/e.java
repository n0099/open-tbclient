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
    private c bSu;
    private volatile boolean bSv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        static final e bSz = new e();
    }

    private e() {
        this.bSv = false;
        this.bSu = new c(this);
        com.baidu.swan.apps.extcore.cores.a.ZI().ZJ();
    }

    public static e Zu() {
        return a.bSz;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void p(Bundle bundle) {
        if (!this.bSv) {
            synchronized (this) {
                if (!this.bSv) {
                    q(bundle);
                    this.bSv = true;
                }
            }
        }
    }

    public c Zv() {
        return this.bSu;
    }

    private void q(Bundle bundle) {
        r(bundle);
        SwanLauncher.Zx().initEnv();
        b.a.Ti();
    }

    private void r(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        j ack = com.baidu.swan.apps.w.a.ack();
        if (ack != null) {
            final int OO = ack.OO();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + OO);
            }
            if (!ack.OP()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && ack.OQ()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + OO);
                    }
                    ai.c(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + OO);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.w.a.ack().OR());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + OO);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
