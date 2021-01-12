package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    private static a cKC;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cKA = "";
    private static String cKB = "";
    private static int cKD = 0;

    public static void lC(String str) {
        cKA = str;
    }

    public static void lD(String str) {
        cKB = str;
    }

    public static String alt() {
        return cKA;
    }

    public static String alu() {
        return cKB;
    }

    public static String alv() {
        return cKC != null ? cKC.als() + File.separator + cKB : "";
    }

    public static String alw() {
        return cKC != null ? cKC.als() + File.separator + cKA : "";
    }

    public static boolean alx() {
        return cKD == 2;
    }

    public static boolean aly() {
        return cKD == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            cKC = new d();
            cKD = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            cKC = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            cKD = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            cKD = 0;
            cKC = null;
            return;
        }
        cKC.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (cKC != null) {
            cKC.o(bundle);
        }
    }
}
