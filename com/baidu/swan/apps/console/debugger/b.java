package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    private static a cey;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cew = "";
    private static String cex = "";
    private static int cez = 0;

    public static void kZ(String str) {
        cew = str;
    }

    public static void la(String str) {
        cex = str;
    }

    public static String aev() {
        return cew;
    }

    public static String aew() {
        return cex;
    }

    public static String aex() {
        return cey != null ? cey.aeu() + File.separator + cex : "";
    }

    public static String aey() {
        return cey != null ? cey.aeu() + File.separator + cew : "";
    }

    public static boolean aez() {
        return cez == 2;
    }

    public static boolean aeA() {
        return cez == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            cey = new d();
            cez = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            cey = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            cez = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            cez = 0;
            cey = null;
            return;
        }
        cey.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (cey != null) {
            cey.o(bundle);
        }
    }
}
