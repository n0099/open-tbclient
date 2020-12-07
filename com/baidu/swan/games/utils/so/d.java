package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes25.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long efx = -1;

    public static f bal() {
        if (!com.baidu.swan.apps.t.a.azN().akT()) {
            return com.baidu.swan.apps.core.k.a.fl(false);
        }
        if (!ban()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.azR().bQ(a.efy);
        return f.baw();
    }

    public static boolean bam() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean ban() {
        boolean z = a.efy > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void bao() {
        com.baidu.swan.apps.t.a.azR().akm();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void bap() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aIs().aIu().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aIf() || next.aIc()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.azR().akn();
    }

    public static String baq() {
        return com.baidu.swan.apps.t.a.azR().bR(a.efy);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.azR().ako());
    }

    public static void z(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            efx = intent.getLongExtra("bundle_key_new_v8_so_switch", efx);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + efx);
        }
    }

    public static long ako() {
        return a.efy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a {
        private static final long efy = d.efx;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + efy);
            }
        }
    }
}
