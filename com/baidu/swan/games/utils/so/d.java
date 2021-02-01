package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes9.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long elR = -1;

    public static f aYY() {
        if (!com.baidu.swan.apps.t.a.axJ().aiI()) {
            return com.baidu.swan.apps.core.k.a.fs(false);
        }
        if (!aZa()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.axN().bX(a.elS);
        return f.aZj();
    }

    public static boolean aYZ() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean aZa() {
        boolean z = a.elS > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aZb() {
        com.baidu.swan.apps.t.a.axN().ahZ();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aZc() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aGn().aGp().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aGa() || next.aFX()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.axN().aia();
    }

    public static String aZd() {
        return com.baidu.swan.apps.t.a.axN().bY(a.elS);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.axN().aib());
    }

    public static void A(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            elR = intent.getLongExtra("bundle_key_new_v8_so_switch", elR);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + elR);
        }
    }

    public static long aib() {
        return a.elS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final long elS = d.elR;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + elS);
            }
        }
    }
}
