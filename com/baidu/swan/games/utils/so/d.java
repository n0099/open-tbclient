package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long csT = -1;

    public static void aqh() {
        if (!com.baidu.swan.apps.w.a.UI().ID()) {
            com.baidu.swan.apps.core.j.a.cx(false);
        } else if (!aql()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        } else {
            com.baidu.swan.apps.w.a.UM().aa(a.csU);
        }
    }

    public static void aqi() {
        SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static void aqj() {
        SoLoader.load(AppRuntime.getAppContext(), "arcore_sdk_c");
    }

    public static void aqk() {
        if (!com.baidu.swan.apps.w.a.UI().ID()) {
            com.baidu.swan.apps.core.j.a.cx(false);
        } else if (!aql()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext(), false);
        } else {
            com.baidu.swan.apps.w.a.UM().aa(a.csU);
        }
    }

    private static boolean aql() {
        boolean z = a.csU > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aqm() {
        com.baidu.swan.apps.w.a.UM().HL();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aqn() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.abu().abw().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.abl() || next.abi()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.w.a.UM().HM();
    }

    public static String aqo() {
        return com.baidu.swan.apps.w.a.UM().ab(a.csU);
    }

    public static void S(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.w.a.UM().HN());
    }

    public static void P(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            csT = intent.getLongExtra("bundle_key_new_v8_so_switch", csT);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + csT);
        }
    }

    public static long HN() {
        return a.csU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final long csU = d.csT;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + csU);
            }
        }
    }
}
