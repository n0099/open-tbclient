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

    public static f bcG() {
        if (!com.baidu.swan.apps.t.a.aBf().ame()) {
            return com.baidu.swan.apps.core.k.a.fu(false);
        }
        if (!bcI()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.aBj().bR(a.eoA);
        return f.bcR();
    }

    public static boolean bcH() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean bcI() {
        boolean z = a.eoA > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void bcJ() {
        com.baidu.swan.apps.t.a.aBj().alv();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void bcK() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aJM().aJO().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aJz() || next.aJw()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.aBj().alw();
    }

    public static String bcL() {
        return com.baidu.swan.apps.t.a.aBj().bS(a.eoA);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.aBj().alx());
    }

    public static void A(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            eoz = intent.getLongExtra("bundle_key_new_v8_so_switch", eoz);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + eoz);
        }
    }

    public static long alx() {
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
