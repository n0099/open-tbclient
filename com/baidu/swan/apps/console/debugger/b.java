package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    private static a cOq;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cOo = "";
    private static String cOp = "";
    private static int cOr = 0;

    public static void mb(String str) {
        cOo = str;
    }

    public static void mc(String str) {
        cOp = str;
    }

    public static String alU() {
        return cOo;
    }

    public static String alV() {
        return cOp;
    }

    public static String alW() {
        return cOq != null ? cOq.alT() + File.separator + cOp : "";
    }

    public static String alX() {
        return cOq != null ? cOq.alT() + File.separator + cOo : "";
    }

    public static boolean alY() {
        return cOr == 2;
    }

    public static boolean alZ() {
        return cOr == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            cOq = new d();
            cOr = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            cOq = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            cOr = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            cOr = 0;
            cOq = null;
            return;
        }
        cOq.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (cOq != null) {
            cOq.o(bundle);
        }
    }
}
