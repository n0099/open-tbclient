package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long dLR = -1;

    public static f aTu() {
        if (!com.baidu.swan.apps.t.a.asT().adZ()) {
            return com.baidu.swan.apps.core.k.a.ex(false);
        }
        if (!aTw()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        com.baidu.swan.apps.t.a.asX().aT(a.dLS);
        return f.aTF();
    }

    public static boolean aTv() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    private static boolean aTw() {
        boolean z = a.dLS > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aTx() {
        com.baidu.swan.apps.t.a.asX().ads();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aTy() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aBy().aBA().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aBl() || next.aBi()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.t.a.asX().adt();
    }

    public static String aTz() {
        return com.baidu.swan.apps.t.a.asX().aU(a.dLS);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.t.a.asX().adu());
    }

    public static void z(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            dLR = intent.getLongExtra("bundle_key_new_v8_so_switch", dLR);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + dLR);
        }
    }

    public static long adu() {
        return a.dLS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final long dLS = d.dLR;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + dLS);
            }
        }
    }
}
