package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    private static a ccw;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String ccu = "";
    private static String ccv = "";
    private static int ccx = 0;

    public static void kG(String str) {
        ccu = str;
    }

    public static void kH(String str) {
        ccv = str;
    }

    public static String adL() {
        return ccu;
    }

    public static String adM() {
        return ccv;
    }

    public static String adN() {
        return ccw != null ? ccw.adK() + File.separator + ccv : "";
    }

    public static String adO() {
        return ccw != null ? ccw.adK() + File.separator + ccu : "";
    }

    public static boolean adP() {
        return ccx == 2;
    }

    public static boolean adQ() {
        return ccx == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            ccw = new d();
            ccx = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            ccw = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            ccx = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            ccx = 0;
            ccw = null;
            return;
        }
        ccw.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (ccw != null) {
            ccw.o(bundle);
        }
    }
}
