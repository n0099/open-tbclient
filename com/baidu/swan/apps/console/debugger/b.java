package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static a bIi;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bIg = "";
    private static String bIh = "";
    private static int bIj = 0;

    public static void hM(String str) {
        bIg = str;
    }

    public static void hN(String str) {
        bIh = str;
    }

    public static String Tn() {
        return bIg;
    }

    public static String To() {
        return bIh;
    }

    public static String Tp() {
        return bIi != null ? bIi.Tm() + File.separator + bIh : "";
    }

    public static String Tq() {
        return bIi != null ? bIi.Tm() + File.separator + bIg : "";
    }

    public static boolean Tr() {
        return bIj == 2;
    }

    public static boolean Ts() {
        return bIj == 1;
    }

    public static void n(Bundle bundle) {
        String e = r.e(bundle, "extraWSUrl");
        String e2 = r.e(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(e)) {
            bIi = new d();
            bIj = 1;
        } else if (!TextUtils.isEmpty(e2)) {
            bIi = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            bIj = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            bIj = 0;
            bIi = null;
            return;
        }
        bIi.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (bIi != null) {
            bIi.o(bundle);
        }
    }
}
