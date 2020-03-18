package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static a bka;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bjY = "";
    private static String bjZ = "";
    private static int bkb = 0;

    public static void gz(String str) {
        bjY = str;
    }

    public static void gA(String str) {
        bjZ = str;
    }

    public static String Lz() {
        return bjY;
    }

    public static String LA() {
        return bjZ;
    }

    public static String LB() {
        return bka != null ? bka.Ly() + File.separator + bjZ : "";
    }

    public static String LC() {
        return bka != null ? bka.Ly() + File.separator + bjY : "";
    }

    public static boolean LD() {
        return bkb == 2;
    }

    public static boolean LE() {
        return bkb == 1;
    }

    public static void n(Bundle bundle) {
        String e = r.e(bundle, "extraWSUrl");
        String e2 = r.e(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(e)) {
            bka = new d();
            bkb = 1;
        } else if (!TextUtils.isEmpty(e2)) {
            bka = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            bkb = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            bkb = 0;
            bka = null;
            return;
        }
        bka.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (bka != null) {
            bka.o(bundle);
        }
    }
}
