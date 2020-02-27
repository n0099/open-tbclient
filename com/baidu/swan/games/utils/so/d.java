package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long csS = -1;

    public static void aqf() {
        if (!com.baidu.swan.apps.w.a.UG().IB()) {
            com.baidu.swan.apps.core.j.a.cx(false);
        } else if (!aqj()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        } else {
            com.baidu.swan.apps.w.a.UK().aa(a.csT);
        }
    }

    public static void aqg() {
        SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static void aqh() {
        SoLoader.load(AppRuntime.getAppContext(), "arcore_sdk_c");
    }

    public static void aqi() {
        if (!com.baidu.swan.apps.w.a.UG().IB()) {
            com.baidu.swan.apps.core.j.a.cx(false);
        } else if (!aqj()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext(), false);
        } else {
            com.baidu.swan.apps.w.a.UK().aa(a.csT);
        }
    }

    private static boolean aqj() {
        boolean z = a.csT > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aqk() {
        com.baidu.swan.apps.w.a.UK().HJ();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aql() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.abs().abu().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.abj() || next.abg()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.w.a.UK().HK();
    }

    public static String aqm() {
        return com.baidu.swan.apps.w.a.UK().ab(a.csT);
    }

    public static void S(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.w.a.UK().HL());
    }

    public static void P(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            csS = intent.getLongExtra("bundle_key_new_v8_so_switch", csS);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + csS);
        }
    }

    public static long HL() {
        return a.csT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final long csT = d.csS;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + csT);
            }
        }
    }
}
