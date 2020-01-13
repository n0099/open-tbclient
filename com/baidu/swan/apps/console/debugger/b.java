package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    private static a bfy;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bfw = "";
    private static String bfx = "";
    private static int bfz = 0;

    public static void gk(String str) {
        bfw = str;
    }

    public static void gl(String str) {
        bfx = str;
    }

    public static String Jf() {
        return bfw;
    }

    public static String Jg() {
        return bfx;
    }

    public static String Jh() {
        return bfy != null ? bfy.Je() + File.separator + bfx : "";
    }

    public static String Ji() {
        return bfy != null ? bfy.Je() + File.separator + bfw : "";
    }

    public static boolean Jj() {
        return bfz == 2;
    }

    public static boolean Jk() {
        return bfz == 1;
    }

    public static void n(Bundle bundle) {
        String e = r.e(bundle, "extraWSUrl");
        String e2 = r.e(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(e)) {
            bfy = new d();
            bfz = 1;
        } else if (!TextUtils.isEmpty(e2)) {
            bfy = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            bfz = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            bfz = 0;
            bfy = null;
            return;
        }
        bfy.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (bfy != null) {
            bfy.o(bundle);
        }
    }
}
