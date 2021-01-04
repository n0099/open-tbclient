package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes9.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long eoz = -1;

    public static f bcF() {
        if (!com.baidu.swan.apps.t.a.aBe().amd()) {
            return com.baidu.swan.apps.core.k.a.fu(false);
        }
        if (!bcH()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.aBi().bR(a.eoA);
        return f.bcQ();
    }

    public static boolean bcG() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean bcH() {
        boolean z = a.eoA > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void bcI() {
        com.baidu.swan.apps.t.a.aBi().alu();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void bcJ() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aJL().aJN().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aJy() || next.aJv()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.aBi().alv();
    }

    public static String bcK() {
        return com.baidu.swan.apps.t.a.aBi().bS(a.eoA);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.aBi().alw());
    }

    public static void A(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            eoz = intent.getLongExtra("bundle_key_new_v8_so_switch", eoz);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + eoz);
        }
    }

    public static long alw() {
        return a.eoA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final long eoA = d.eoz;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + eoA);
            }
        }
    }
}
