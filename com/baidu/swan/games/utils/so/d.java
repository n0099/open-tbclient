package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long ctf = -1;

    public static void aqk() {
        if (!com.baidu.swan.apps.w.a.UL().IG()) {
            com.baidu.swan.apps.core.j.a.cy(false);
        } else if (!aqo()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        } else {
            com.baidu.swan.apps.w.a.UP().aa(a.ctg);
        }
    }

    public static void aql() {
        SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static void aqm() {
        SoLoader.load(AppRuntime.getAppContext(), "arcore_sdk_c");
    }

    public static void aqn() {
        if (!com.baidu.swan.apps.w.a.UL().IG()) {
            com.baidu.swan.apps.core.j.a.cy(false);
        } else if (!aqo()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext(), false);
        } else {
            com.baidu.swan.apps.w.a.UP().aa(a.ctg);
        }
    }

    private static boolean aqo() {
        boolean z = a.ctg > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aqp() {
        com.baidu.swan.apps.w.a.UP().HO();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aqq() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.abx().abz().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.abo() || next.abl()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.w.a.UP().HP();
    }

    public static String aqr() {
        return com.baidu.swan.apps.w.a.UP().ab(a.ctg);
    }

    public static void S(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.w.a.UP().HQ());
    }

    public static void P(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            ctf = intent.getLongExtra("bundle_key_new_v8_so_switch", ctf);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + ctf);
        }
    }

    public static long HQ() {
        return a.ctg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final long ctg = d.ctf;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + ctg);
            }
        }
    }
}
