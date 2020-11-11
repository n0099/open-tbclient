package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    private static a cFi;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cFg = "";
    private static String cFh = "";
    private static int cFj = 0;

    public static void mt(String str) {
        cFg = str;
    }

    public static void mu(String str) {
        cFh = str;
    }

    public static String alA() {
        return cFg;
    }

    public static String alB() {
        return cFh;
    }

    public static String alC() {
        return cFi != null ? cFi.alz() + File.separator + cFh : "";
    }

    public static String alD() {
        return cFi != null ? cFi.alz() + File.separator + cFg : "";
    }

    public static boolean alE() {
        return cFj == 2;
    }

    public static boolean alF() {
        return cFj == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            cFi = new d();
            cFj = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            cFi = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            cFj = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            cFj = 0;
            cFi = null;
            return;
        }
        cFi.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (cFi != null) {
            cFi.o(bundle);
        }
    }
}
