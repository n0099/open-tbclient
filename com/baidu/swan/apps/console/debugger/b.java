package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    private static a cDy;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cDw = "";
    private static String cDx = "";
    private static int cDz = 0;

    public static void mn(String str) {
        cDw = str;
    }

    public static void mo(String str) {
        cDx = str;
    }

    public static String akS() {
        return cDw;
    }

    public static String akT() {
        return cDx;
    }

    public static String akU() {
        return cDy != null ? cDy.akR() + File.separator + cDx : "";
    }

    public static String akV() {
        return cDy != null ? cDy.akR() + File.separator + cDw : "";
    }

    public static boolean akW() {
        return cDz == 2;
    }

    public static boolean akX() {
        return cDz == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            cDy = new d();
            cDz = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            cDy = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            cDz = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            cDz = 0;
            cDy = null;
            return;
        }
        cDy.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (cDy != null) {
            cDy.o(bundle);
        }
    }
}
