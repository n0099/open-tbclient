package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes9.dex */
public class b {
    private static a cMQ;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cMO = "";
    private static String cMP = "";
    private static int cMR = 0;

    public static void lU(String str) {
        cMO = str;
    }

    public static void lV(String str) {
        cMP = str;
    }

    public static String alR() {
        return cMO;
    }

    public static String alS() {
        return cMP;
    }

    public static String alT() {
        return cMQ != null ? cMQ.alQ() + File.separator + cMP : "";
    }

    public static String alU() {
        return cMQ != null ? cMQ.alQ() + File.separator + cMO : "";
    }

    public static boolean alV() {
        return cMR == 2;
    }

    public static boolean alW() {
        return cMR == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            cMQ = new d();
            cMR = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            cMQ = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            cMR = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            cMR = 0;
            cMQ = null;
            return;
        }
        cMQ.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (cMQ != null) {
            cMQ.o(bundle);
        }
    }
}
