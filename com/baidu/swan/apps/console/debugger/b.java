package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    private static a cqO;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cqM = "";
    private static String cqN = "";
    private static int cqP = 0;

    public static void lL(String str) {
        cqM = str;
    }

    public static void lM(String str) {
        cqN = str;
    }

    public static String ahg() {
        return cqM;
    }

    public static String ahh() {
        return cqN;
    }

    public static String ahi() {
        return cqO != null ? cqO.ahf() + File.separator + cqN : "";
    }

    public static String ahj() {
        return cqO != null ? cqO.ahf() + File.separator + cqM : "";
    }

    public static boolean ahk() {
        return cqP == 2;
    }

    public static boolean ahl() {
        return cqP == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            cqO = new d();
            cqP = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            cqO = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            cqP = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            cqP = 0;
            cqO = null;
            return;
        }
        cqO.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (cqO != null) {
            cqO.o(bundle);
        }
    }
}
