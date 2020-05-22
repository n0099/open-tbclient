package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long ddd = -1;

    public static boolean aCo() {
        if (!com.baidu.swan.apps.u.a.afC().SV()) {
            com.baidu.swan.apps.core.k.a.dJ(false);
            return true;
        } else if (!aCr()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        } else {
            com.baidu.swan.apps.u.a.afG().aJ(a.dde);
            return true;
        }
    }

    public static boolean aCp() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static void aCq() {
        SoLoader.load(AppRuntime.getAppContext(), "arcore_sdk_c");
    }

    private static boolean aCr() {
        boolean z = a.dde > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aCs() {
        com.baidu.swan.apps.u.a.afG().Sq();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aCt() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.anp().anr().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.ang() || next.and()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.u.a.afG().Sr();
    }

    public static String aCu() {
        return com.baidu.swan.apps.u.a.afG().aK(a.dde);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.u.a.afG().Ss());
    }

    public static void x(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            ddd = intent.getLongExtra("bundle_key_new_v8_so_switch", ddd);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + ddd);
        }
    }

    public static long Ss() {
        return a.dde;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final long dde = d.ddd;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + dde);
            }
        }
    }
}
