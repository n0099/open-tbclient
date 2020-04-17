package com.baidu.swan.games.utils.so;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Iterator;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long cSa = -1;

    public static void ayw() {
        if (!com.baidu.swan.apps.w.a.acA().Qs()) {
            com.baidu.swan.apps.core.j.a.du(false);
        } else if (!ayA()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        } else {
            com.baidu.swan.apps.w.a.acE().aE(a.cSb);
        }
    }

    public static void ayx() {
        SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static void ayy() {
        SoLoader.load(AppRuntime.getAppContext(), "arcore_sdk_c");
    }

    public static void ayz() {
        if (!com.baidu.swan.apps.w.a.acA().Qs()) {
            com.baidu.swan.apps.core.j.a.du(false);
        } else if (!ayA()) {
            SoLoader.loadV8EngineSo(AppRuntime.getAppContext(), false);
        } else {
            com.baidu.swan.apps.w.a.acE().aE(a.cSb);
        }
    }

    private static boolean ayA() {
        boolean z = a.cSb > -1;
        if (DEBUG) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static void ayB() {
        com.baidu.swan.apps.w.a.acE().PA();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void ayC() {
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = com.baidu.swan.apps.process.messaging.service.e.ajC().ajE().iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.ajt() || next.ajq()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        com.baidu.swan.apps.w.a.acE().PB();
    }

    public static String ayD() {
        return com.baidu.swan.apps.w.a.acE().aF(a.cSb);
    }

    public static void S(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", com.baidu.swan.apps.w.a.acE().PC());
    }

    public static void O(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            cSa = intent.getLongExtra("bundle_key_new_v8_so_switch", cSa);
        }
        if (DEBUG) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + cSa);
        }
    }

    public static long PC() {
        return a.cSb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final long cSb = d.cSa;

        static {
            if (d.DEBUG) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + cSb);
            }
        }
    }
}
