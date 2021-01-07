package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes9.dex */
public class b {
    private static a cPo;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cPm = "";
    private static String cPn = "";
    private static int cPp = 0;

    public static void mN(String str) {
        cPm = str;
    }

    public static void mO(String str) {
        cPn = str;
    }

    public static String apo() {
        return cPm;
    }

    public static String app() {
        return cPn;
    }

    public static String apq() {
        return cPo != null ? cPo.apn() + File.separator + cPn : "";
    }

    public static String apr() {
        return cPo != null ? cPo.apn() + File.separator + cPm : "";
    }

    public static boolean aps() {
        return cPp == 2;
    }

    public static boolean apt() {
        return cPp == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            cPo = new d();
            cPp = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            cPo = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            cPp = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            cPp = 0;
            cPo = null;
            return;
        }
        cPo.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (cPo != null) {
            cPo.o(bundle);
        }
    }
}
