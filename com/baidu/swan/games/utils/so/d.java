package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long dzQ = -1;

    public static f aQL() {
        if (!com.baidu.swan.apps.t.a.aqh().abn()) {
            return com.baidu.swan.apps.core.k.a.eb(false);
        }
        if (!aQN()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.aql().aL(a.dzR);
        return f.aQW();
    }

    public static boolean aQM() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean aQN() {
        boolean z = a.dzR > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aQO() {
        com.baidu.swan.apps.t.a.aql().aaG();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aQP() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.ayP().ayR().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.ayC() || next.ayz()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.aql().aaH();
    }

    public static String aQQ() {
        return com.baidu.swan.apps.t.a.aql().aM(a.dzR);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.aql().aaI());
    }

    public static void z(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            dzQ = intent.getLongExtra("bundle_key_new_v8_so_switch", dzQ);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + dzQ);
        }
    }

    public static long aaI() {
        return a.dzR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private static final long dzR = d.dzQ;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + dzR);
            }
        }
    }
}
