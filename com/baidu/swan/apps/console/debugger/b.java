package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes25.dex */
public class b {
    private static a cKt;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cKr = "";
    private static String cKs = "";
    private static int cKu = 0;

    public static void mU(String str) {
        cKr = str;
    }

    public static void mV(String str) {
        cKs = str;
    }

    public static String aoa() {
        return cKr;
    }

    public static String aob() {
        return cKs;
    }

    public static String aoc() {
        return cKt != null ? cKt.anZ() + File.separator + cKs : "";
    }

    public static String aod() {
        return cKt != null ? cKt.anZ() + File.separator + cKr : "";
    }

    public static boolean aoe() {
        return cKu == 2;
    }

    public static boolean aof() {
        return cKu == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            cKt = new d();
            cKu = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            cKt = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            cKu = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            cKu = 0;
            cKt = null;
            return;
        }
        cKt.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (cKt != null) {
            cKt.o(bundle);
        }
    }
}
