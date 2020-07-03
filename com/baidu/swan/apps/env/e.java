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
    private c cgZ;
    private volatile boolean cha;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        static final e che = new e();
    }

    private e() {
        this.cha = false;
        this.cgZ = new c(this);
        com.baidu.swan.apps.extcore.cores.a.adO().adP();
    }

    public static e adB() {
        return a.che;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void s(Bundle bundle) {
        if (!this.cha) {
            synchronized (this) {
                if (!this.cha) {
                    t(bundle);
                    this.cha = true;
                }
            }
        }
    }

    public c adC() {
        return this.cgZ;
    }

    private void t(Bundle bundle) {
        u(bundle);
        SwanLauncher.adE().e(null);
        b.a.WV();
        am.avb();
        com.baidu.swan.apps.u.a.agV().Tu();
    }

    private void u(final Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        k agt = com.baidu.swan.apps.u.a.agt();
        if (agt != null) {
            final int Sg = agt.Sg();
            if (DEBUG) {
                Log.d("SwanAppEnv", "zygoteSwanProcess switch : " + Sg);
            }
            if (!agt.Sh()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                    bundle.putString("bundle_key_preload_preload_scene", "0");
                }
                if (bundle.getBoolean("bundle_key_preload_delay", false) && agt.Si()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "zygoteSwanProcess delay - start. switch: " + Sg);
                    }
                    aj.c(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "zygoteSwanProcess delay - run. switch: " + Sg);
                            }
                            com.baidu.swan.apps.process.messaging.service.b.b(e.this.requireContext(), bundle);
                        }
                    }, com.baidu.swan.apps.u.a.agt().Sj());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "zygoteSwanProcess start. switch: " + Sg);
                }
                com.baidu.swan.apps.process.messaging.service.b.b(requireContext(), bundle);
            }
        }
    }
}
