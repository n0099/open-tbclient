package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes8.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long ejK = -1;

    public static f aYM() {
        if (!com.baidu.swan.apps.t.a.axl().aik()) {
            return com.baidu.swan.apps.core.k.a.fq(false);
        }
        if (!aYO()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.axp().bR(a.ejL);
        return f.aYX();
    }

    public static boolean aYN() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean aYO() {
        boolean z = a.ejL > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aYP() {
        com.baidu.swan.apps.t.a.axp().ahB();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aYQ() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aFS().aFU().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aFF() || next.aFC()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.axp().ahC();
    }

    public static String aYR() {
        return com.baidu.swan.apps.t.a.axp().bS(a.ejL);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.axp().ahD());
    }

    public static void A(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            ejK = intent.getLongExtra("bundle_key_new_v8_so_switch", ejK);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + ejK);
        }
    }

    public static long ahD() {
        return a.ejL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final long ejL = d.ejK;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + ejL);
            }
        }
    }
}
