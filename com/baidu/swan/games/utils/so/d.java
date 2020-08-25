package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes8.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long dxL = -1;

    public static f aQa() {
        if (!com.baidu.swan.apps.t.a.apx().aaE()) {
            return com.baidu.swan.apps.core.k.a.ec(false);
        }
        if (!aQc()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.apB().aK(a.dxM);
        return f.aQk();
    }

    public static boolean aQb() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean aQc() {
        boolean z = a.dxM > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aQd() {
        com.baidu.swan.apps.t.a.apB().ZX();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aQe() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.ayg().ayi().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.axT() || next.axQ()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.apB().ZY();
    }

    public static String aQf() {
        return com.baidu.swan.apps.t.a.apB().aL(a.dxM);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.apB().ZZ());
    }

    public static void z(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            dxL = intent.getLongExtra("bundle_key_new_v8_so_switch", dxL);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + dxL);
        }
    }

    public static long ZZ() {
        return a.dxM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final long dxM = d.dxL;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + dxM);
            }
        }
    }
}
