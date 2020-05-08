package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static a bIn;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bIl = "";
    private static String bIm = "";
    private static int bIo = 0;

    public static void hM(String str) {
        bIl = str;
    }

    public static void hN(String str) {
        bIm = str;
    }

    public static String Tm() {
        return bIl;
    }

    public static String Tn() {
        return bIm;
    }

    public static String To() {
        return bIn != null ? bIn.Tl() + File.separator + bIm : "";
    }

    public static String Tp() {
        return bIn != null ? bIn.Tl() + File.separator + bIl : "";
    }

    public static boolean Tq() {
        return bIo == 2;
    }

    public static boolean Tr() {
        return bIo == 1;
    }

    public static void n(Bundle bundle) {
        String e = r.e(bundle, "extraWSUrl");
        String e2 = r.e(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(e)) {
            bIn = new d();
            bIo = 1;
        } else if (!TextUtils.isEmpty(e2)) {
            bIn = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            bIo = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            bIo = 0;
            bIn = null;
            return;
        }
        bIn.n(bundle);
    }

    public static void o(Bundle bundle) {
        if (bIn != null) {
            bIn.o(bundle);
        }
    }
}
