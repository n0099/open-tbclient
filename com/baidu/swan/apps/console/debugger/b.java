package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static a bjL;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bjJ = "";
    private static String bjK = "";
    private static int bjM = 0;

    public static void gA(String str) {
        bjJ = str;
    }

    public static void gB(String str) {
        bjK = str;
    }

    public static String Lu() {
        return bjJ;
    }

    public static String Lv() {
        return bjK;
    }

    public static String Lw() {
        return bjL != null ? bjL.Lt() + File.separator + bjK : "";
    }

    public static String Lx() {
        return bjL != null ? bjL.Lt() + File.separator + bjJ : "";
    }

    public static boolean Ly() {
        return bjM == 2;
    }

    public static boolean Lz() {
        return bjM == 1;
    }

    public static void n(Bundle bundle) {
        String e = r.e(bundle, "extraWSUrl");
        String e2 = r.e(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(e)) {
            bjL = new d();
            bjM = 1;
        } else if (!TextUtils.isEmpty(e2)) {
            bjL = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            bjM = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            bjM = 0;
            bjL = null;
            return;
        }
        bjL.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (bjL != null) {
            bjL.o(bundle);
        }
    }
}
