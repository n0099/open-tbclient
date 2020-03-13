package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static a bjN;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bjL = "";
    private static String bjM = "";
    private static int bjO = 0;

    public static void gA(String str) {
        bjL = str;
    }

    public static void gB(String str) {
        bjM = str;
    }

    public static String Lw() {
        return bjL;
    }

    public static String Lx() {
        return bjM;
    }

    public static String Ly() {
        return bjN != null ? bjN.Lv() + File.separator + bjM : "";
    }

    public static String Lz() {
        return bjN != null ? bjN.Lv() + File.separator + bjL : "";
    }

    public static boolean LA() {
        return bjO == 2;
    }

    public static boolean LB() {
        return bjO == 1;
    }

    public static void n(Bundle bundle) {
        String e = r.e(bundle, "extraWSUrl");
        String e2 = r.e(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(e)) {
            bjN = new d();
            bjO = 1;
        } else if (!TextUtils.isEmpty(e2)) {
            bjN = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            bjO = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            bjO = 0;
            bjN = null;
            return;
        }
        bjN.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (bjN != null) {
            bjN.o(bundle);
        }
    }
}
