package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long dUo = -1;

    public static f aVo() {
        if (!com.baidu.swan.apps.t.a.auN().afT()) {
            return com.baidu.swan.apps.core.k.a.eK(false);
        }
        if (!aVq()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.auR().aV(a.dUp);
        return f.aVz();
    }

    public static boolean aVp() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean aVq() {
        boolean z = a.dUp > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aVr() {
        com.baidu.swan.apps.t.a.auR().afm();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aVs() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aDs().aDu().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aDf() || next.aDc()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.auR().afn();
    }

    public static String aVt() {
        return com.baidu.swan.apps.t.a.auR().aW(a.dUp);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.auR().afo());
    }

    public static void z(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            dUo = intent.getLongExtra("bundle_key_new_v8_so_switch", dUo);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + dUo);
        }
    }

    public static long afo() {
        return a.dUp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final long dUp = d.dUo;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + dUp);
            }
        }
    }
}
