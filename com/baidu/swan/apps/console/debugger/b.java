package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    private static a bWJ;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bWH = "";
    private static String bWI = "";
    private static int bWK = 0;

    public static void jf(String str) {
        bWH = str;
    }

    public static void jg(String str) {
        bWI = str;
    }

    public static String XF() {
        return bWH;
    }

    public static String XG() {
        return bWI;
    }

    public static String XH() {
        return bWJ != null ? bWJ.XE() + File.separator + bWI : "";
    }

    public static String XI() {
        return bWJ != null ? bWJ.XE() + File.separator + bWH : "";
    }

    public static boolean XJ() {
        return bWK == 2;
    }

    public static boolean XK() {
        return bWK == 1;
    }

    public static void p(Bundle bundle) {
        String f = u.f(bundle, "extraWSUrl");
        String f2 = u.f(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(f)) {
            bWJ = new d();
            bWK = 1;
        } else if (!TextUtils.isEmpty(f2)) {
            bWJ = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            bWK = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            bWK = 0;
            bWJ = null;
            return;
        }
        bWJ.p(bundle);
    }

    public static void q(Bundle bundle) {
        if (bWJ != null) {
            bWJ.q(bundle);
        }
    }
}
