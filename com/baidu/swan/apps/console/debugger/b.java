package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static a bjM;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bjK = "";
    private static String bjL = "";
    private static int bjN = 0;

    public static void gA(String str) {
        bjK = str;
    }

    public static void gB(String str) {
        bjL = str;
    }

    public static String Lw() {
        return bjK;
    }

    public static String Lx() {
        return bjL;
    }

    public static String Ly() {
        return bjM != null ? bjM.Lv() + File.separator + bjL : "";
    }

    public static String Lz() {
        return bjM != null ? bjM.Lv() + File.separator + bjK : "";
    }

    public static boolean LA() {
        return bjN == 2;
    }

    public static boolean LB() {
        return bjN == 1;
    }

    public static void n(Bundle bundle) {
        String e = r.e(bundle, "extraWSUrl");
        String e2 = r.e(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(e)) {
            bjM = new d();
            bjN = 1;
        } else if (!TextUtils.isEmpty(e2)) {
            bjM = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            bjN = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            bjN = 0;
            bjM = null;
            return;
        }
        bjM.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (bjM != null) {
            bjM.o(bundle);
        }
    }
}
