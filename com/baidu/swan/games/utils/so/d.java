package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes8.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long ent = -1;

    public static f aZb() {
        if (!com.baidu.swan.apps.t.a.axM().aiL()) {
            return com.baidu.swan.apps.core.k.a.fs(false);
        }
        if (!aZd()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.axQ().bX(a.enu);
        return f.aZm();
    }

    public static boolean aZc() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean aZd() {
        boolean z = a.enu > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aZe() {
        com.baidu.swan.apps.t.a.axQ().aic();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aZf() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aGq().aGs().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aGd() || next.aGa()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.axQ().aid();
    }

    public static String aZg() {
        return com.baidu.swan.apps.t.a.axQ().bY(a.enu);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.axQ().aie());
    }

    public static void A(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            ent = intent.getLongExtra("bundle_key_new_v8_so_switch", ent);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + ent);
        }
    }

    public static long aie() {
        return a.enu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final long enu = d.ent;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + enu);
            }
        }
    }
}
