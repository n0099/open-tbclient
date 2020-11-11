package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long eag = -1;

    public static f aXO() {
        if (!com.baidu.swan.apps.t.a.axn().ait()) {
            return com.baidu.swan.apps.core.k.a.eT(false);
        }
        if (!aXQ()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.axr().br(a.eah);
        return f.aXZ();
    }

    public static boolean aXP() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean aXQ() {
        boolean z = a.eah > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aXR() {
        com.baidu.swan.apps.t.a.axr().ahM();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aXS() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aFS().aFU().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aFF() || next.aFC()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.axr().ahN();
    }

    public static String aXT() {
        return com.baidu.swan.apps.t.a.axr().bs(a.eah);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.axr().ahO());
    }

    public static void z(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            eag = intent.getLongExtra("bundle_key_new_v8_so_switch", eag);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + eag);
        }
    }

    public static long ahO() {
        return a.eah;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final long eah = d.eag;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + eah);
            }
        }
    }
}
