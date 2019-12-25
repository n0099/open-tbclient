package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes9.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long coE = -1;

    public static void any() {
        if (!com.baidu.swan.apps.w.a.RW().FQ()) {
            com.baidu.swan.apps.core.j.a.cl(false);
        } else if (!anC()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        } else {
            com.baidu.swan.apps.w.a.Sa().T(a.coF);
        }
    }

    public static void anz() {
        SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static void anA() {
        SoLoader.load(AppRuntime.getAppContext(), "arcore_sdk_c");
    }

    public static void anB() {
        if (!com.baidu.swan.apps.w.a.RW().FQ()) {
            com.baidu.swan.apps.core.j.a.cl(false);
        } else if (!anC()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext(), false);
        } else {
            com.baidu.swan.apps.w.a.Sa().T(a.coF);
        }
    }

    private static boolean anC() {
        boolean z = a.coF > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void anD() {
        com.baidu.swan.apps.w.a.Sa().EY();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void anE() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.YH().YJ().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.Yy() || next.Yv()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.w.a.Sa().EZ();
    }

    public static String anF() {
        return com.baidu.swan.apps.w.a.Sa().U(a.coF);
    }

    public static void S(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.w.a.Sa().Fa());
    }

    public static void P(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            coE = intent.getLongExtra("bundle_key_new_v8_so_switch", coE);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + coE);
        }
    }

    public static long Fa() {
        return a.coF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final long coF = d.coE;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + coF);
            }
        }
    }
}
