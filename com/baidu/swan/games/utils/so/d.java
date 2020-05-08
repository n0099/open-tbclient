package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long cSf = -1;

    public static void ayw() {
        if (!com.baidu.swan.apps.w.a.acz().Qr()) {
            com.baidu.swan.apps.core.j.a.du(false);
        } else if (!ayA()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        } else {
            com.baidu.swan.apps.w.a.acD().aE(a.cSg);
        }
    }

    public static void ayx() {
        SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static void ayy() {
        SoLoader.load(AppRuntime.getAppContext(), "arcore_sdk_c");
    }

    public static void ayz() {
        if (!com.baidu.swan.apps.w.a.acz().Qr()) {
            com.baidu.swan.apps.core.j.a.du(false);
        } else if (!ayA()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext(), false);
        } else {
            com.baidu.swan.apps.w.a.acD().aE(a.cSg);
        }
    }

    private static boolean ayA() {
        boolean z = a.cSg > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void ayB() {
        com.baidu.swan.apps.w.a.acD().Pz();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void ayC() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.ajB().ajD().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.ajs() || next.ajp()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.w.a.acD().PA();
    }

    public static String ayD() {
        return com.baidu.swan.apps.w.a.acD().aF(a.cSg);
    }

    public static void S(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.w.a.acD().PB());
    }

    public static void B(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            cSf = intent.getLongExtra("bundle_key_new_v8_so_switch", cSf);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + cSf);
        }
    }

    public static long PB() {
        return a.cSg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final long cSg = d.cSf;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + cSg);
            }
        }
    }
}
