package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long coR = -1;

    public static void anR() {
        if (!com.baidu.swan.apps.w.a.Ss().Gm()) {
            com.baidu.swan.apps.core.j.a.cq(false);
        } else if (!anV()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        } else {
            com.baidu.swan.apps.w.a.Sw().W(a.coS);
        }
    }

    public static void anS() {
        SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static void anT() {
        SoLoader.load(AppRuntime.getAppContext(), "arcore_sdk_c");
    }

    public static void anU() {
        if (!com.baidu.swan.apps.w.a.Ss().Gm()) {
            com.baidu.swan.apps.core.j.a.cq(false);
        } else if (!anV()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext(), false);
        } else {
            com.baidu.swan.apps.w.a.Sw().W(a.coS);
        }
    }

    private static boolean anV() {
        boolean z = a.coS > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void anW() {
        com.baidu.swan.apps.w.a.Sw().Fu();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void anX() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.Ze().Zg().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.YV() || next.YS()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.w.a.Sw().Fv();
    }

    public static String anY() {
        return com.baidu.swan.apps.w.a.Sw().X(a.coS);
    }

    public static void S(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.w.a.Sw().Fw());
    }

    public static void P(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            coR = intent.getLongExtra("bundle_key_new_v8_so_switch", coR);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + coR);
        }
    }

    public static long Fw() {
        return a.coS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final long coS = d.coR;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + coS);
            }
        }
    }
}
