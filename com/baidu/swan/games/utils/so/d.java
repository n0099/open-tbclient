package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long dhP = -1;

    public static boolean aDu() {
        if (!com.baidu.swan.apps.u.a.agI().Ub()) {
            com.baidu.swan.apps.core.k.a.dO(false);
            return true;
        } else if (!aDx()) {
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        } else {
            com.baidu.swan.apps.u.a.agM().aJ(a.dhQ);
            return true;
        }
    }

    public static boolean aDv() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static void aDw() {
        SoLoader.load(AppRuntime.getAppContext(), "arcore_sdk_c");
    }

    private static boolean aDx() {
        boolean z = a.dhQ > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void aDy() {
        com.baidu.swan.apps.u.a.agM().Tw();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void aDz() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.aov().aox().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aom() || next.aoj()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.u.a.agM().Tx();
    }

    public static String aDA() {
        return com.baidu.swan.apps.u.a.agM().aK(a.dhQ);
    }

    public static void Y(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.u.a.agM().Ty());
    }

    public static void x(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            dhP = intent.getLongExtra("bundle_key_new_v8_so_switch", dhP);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + dhP);
        }
    }

    public static long Ty() {
        return a.dhQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final long dhQ = d.dhP;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + dhQ);
            }
        }
    }
}
