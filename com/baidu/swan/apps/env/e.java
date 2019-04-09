package com.baidu.swan.apps.env;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.env.c;
/* loaded from: classes2.dex */
public final class e implements c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c avd;
    private volatile boolean ave;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        static final e avi = new e();
    }

    private e() {
        this.ave = false;
        this.avd = new c(this);
        com.baidu.swan.apps.extcore.cores.a.Bm().Bn();
    }

    public static e Bd() {
        return a.avi;
    }

    @Override // com.baidu.swan.apps.env.b
    @NonNull
    public Context AX() {
        return AppRuntime.getAppContext();
    }

    public void l(Bundle bundle) {
        if (!this.ave) {
            synchronized (this) {
                if (!this.ave) {
                    m(bundle);
                    this.ave = true;
                }
            }
        }
    }

    public c Be() {
        return this.avd;
    }

    private void m(Bundle bundle) {
        n(bundle);
    }

    private void n(Bundle bundle) {
        if (DEBUG) {
            Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess");
        }
        com.baidu.swan.apps.b.b.e CS = com.baidu.swan.apps.u.a.CS();
        if (CS != null) {
            final int vr = CS.vr();
            if (DEBUG) {
                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess switch: " + vr);
            }
            if (!CS.vs()) {
                String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
                if (TextUtils.isEmpty(string)) {
                    string = "0";
                }
                final Bundle bundle2 = new Bundle();
                bundle2.putString("bundle_key_preload_preload_scene", string);
                if (CS.vt()) {
                    if (DEBUG) {
                        Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - start. switch: " + vr);
                    }
                    aa.b(new Runnable() { // from class: com.baidu.swan.apps.env.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.DEBUG) {
                                Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess delay - run. switch: " + vr);
                            }
                            com.baidu.swan.apps.process.messaging.service.c.c(e.this.AX(), bundle2);
                        }
                    }, com.baidu.swan.apps.u.a.CS().vu());
                    return;
                }
                if (DEBUG) {
                    Log.d("SwanAppEnv", "preloadSwanAppZygoteProcess start. switch: " + vr);
                }
                com.baidu.swan.apps.process.messaging.service.c.c(AX(), bundle2);
            }
        }
    }
}
