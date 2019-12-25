package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes9.dex */
public class b {
    private static a beI;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String beG = "";
    private static String beH = "";
    private static int beJ = 0;

    public static void gh(String str) {
        beG = str;
    }

    public static void gi(String str) {
        beH = str;
    }

    public static String IJ() {
        return beG;
    }

    public static String IK() {
        return beH;
    }

    public static String IL() {
        return beI != null ? beI.II() + File.separator + beH : "";
    }

    public static String IM() {
        return beI != null ? beI.II() + File.separator + beG : "";
    }

    public static boolean IN() {
        return beJ == 2;
    }

    public static boolean IO() {
        return beJ == 1;
    }

    public static void n(Bundle bundle) {
        String e = r.e(bundle, "extraWSUrl");
        String e2 = r.e(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(e)) {
            beI = new d();
            beJ = 1;
        } else if (!TextUtils.isEmpty(e2)) {
            beI = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            beJ = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            beJ = 0;
            beI = null;
            return;
        }
        beI.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (beI != null) {
            beI.o(bundle);
        }
    }
}
