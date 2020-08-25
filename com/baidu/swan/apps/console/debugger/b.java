package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    private static a ccr;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String ccp = "";
    private static String ccq = "";
    private static int cct = 0;

    public static void kF(String str) {
        ccp = str;
    }

    public static void kG(String str) {
        ccq = str;
    }

    public static String adL() {
        return ccp;
    }

    public static String adM() {
        return ccq;
    }

    public static String adN() {
        return ccr != null ? ccr.adK() + File.separator + ccq : "";
    }

    public static String adO() {
        return ccr != null ? ccr.adK() + File.separator + ccp : "";
    }

    public static boolean adP() {
        return cct == 2;
    }

    public static boolean adQ() {
        return cct == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            ccr = new d();
            cct = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            ccr = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            cct = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            cct = 0;
            ccr = null;
            return;
        }
        ccr.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (ccr != null) {
            ccr.o(bundle);
        }
    }
}
