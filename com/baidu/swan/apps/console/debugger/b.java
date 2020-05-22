package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static a bRe;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bRc = "";
    private static String bRd = "";
    private static int bRf = 0;

    public static void iN(String str) {
        bRc = str;
    }

    public static void iO(String str) {
        bRd = str;
    }

    public static String VT() {
        return bRc;
    }

    public static String VU() {
        return bRd;
    }

    public static String VV() {
        return bRe != null ? bRe.VS() + File.separator + bRd : "";
    }

    public static String VW() {
        return bRe != null ? bRe.VS() + File.separator + bRc : "";
    }

    public static boolean VX() {
        return bRf == 2;
    }

    public static boolean VY() {
        return bRf == 1;
    }

    public static void p(Bundle bundle) {
        String f = s.f(bundle, "extraWSUrl");
        String f2 = s.f(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(f)) {
            bRe = new d();
            bRf = 1;
        } else if (!TextUtils.isEmpty(f2)) {
            bRe = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            bRf = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            bRf = 0;
            bRe = null;
            return;
        }
        bRe.p(bundle);
    }

    public static void q(Bundle bundle) {
        if (bRe != null) {
            bRe.q(bundle);
        }
    }
}
