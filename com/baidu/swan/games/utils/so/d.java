package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long dnH = -1;

    public static f aHi() {
        if (!com.baidu.swan.apps.t.a.ahV().UC()) {
            return com.baidu.swan.apps.core.k.a.dS(false);
        }
        if (!aHk()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.ahZ().aJ(a.dnI);
        return f.aHs();
    }

    public static boolean aHj() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean aHk() {
        boolean z = a.dnI > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aHl() {
        com.baidu.swan.apps.t.a.ahZ().TU();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aHm() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aqf().aqh().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.apW() || next.apT()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.ahZ().TV();
    }

    public static String aHn() {
        return com.baidu.swan.apps.t.a.ahZ().aK(a.dnI);
    }

    public static void Z(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.ahZ().TW());
    }

    public static void x(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            dnH = intent.getLongExtra("bundle_key_new_v8_so_switch", dnH);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + dnH);
        }
    }

    public static long TW() {
        return a.dnI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final long dnI = d.dnH;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + dnI);
            }
        }
    }
}
