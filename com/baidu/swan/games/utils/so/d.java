package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long dYy = -1;

    public static f aXg() {
        if (!com.baidu.swan.apps.t.a.awF().ahL()) {
            return com.baidu.swan.apps.core.k.a.eW(false);
        }
        if (!aXi()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.awJ().br(a.dYz);
        return f.aXr();
    }

    public static boolean aXh() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean aXi() {
        boolean z = a.dYz > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aXj() {
        com.baidu.swan.apps.t.a.awJ().ahe();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aXk() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aFk().aFm().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aEX() || next.aEU()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.awJ().ahf();
    }

    public static String aXl() {
        return com.baidu.swan.apps.t.a.awJ().bs(a.dYz);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.awJ().ahg());
    }

    public static void z(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            dYy = intent.getLongExtra("bundle_key_new_v8_so_switch", dYy);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + dYy);
        }
    }

    public static long ahg() {
        return a.dYz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final long dYz = d.dYy;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + dYz);
            }
        }
    }
}
