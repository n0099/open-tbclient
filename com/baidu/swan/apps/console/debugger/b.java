package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    private static a czp;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String czn = "";
    private static String czo = "";
    private static int czq = 0;

    public static void me(String str) {
        czn = str;
    }

    public static void mf(String str) {
        czo = str;
    }

    public static String aja() {
        return czn;
    }

    public static String ajb() {
        return czo;
    }

    public static String ajc() {
        return czp != null ? czp.aiZ() + File.separator + czo : "";
    }

    public static String ajd() {
        return czp != null ? czp.aiZ() + File.separator + czn : "";
    }

    public static boolean aje() {
        return czq == 2;
    }

    public static boolean ajf() {
        return czq == 1;
    }

    public static void n(Bundle bundle) {
        String g = u.g(bundle, "extraWSUrl");
        String g2 = u.g(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(g)) {
            czp = new d();
            czq = 1;
        } else if (!TextUtils.isEmpty(g2)) {
            czp = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            czq = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            czq = 0;
            czp = null;
            return;
        }
        czp.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (czp != null) {
            czp.o(bundle);
        }
    }
}
