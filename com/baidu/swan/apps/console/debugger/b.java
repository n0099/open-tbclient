package com.baidu.swan.apps.console.debugger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.apps.console.debugger.b.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static a bVS;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bVQ = "";
    private static String bVR = "";
    private static int bVT = 0;

    public static void iV(String str) {
        bVQ = str;
    }

    public static void iW(String str) {
        bVR = str;
    }

    public static String WZ() {
        return bVQ;
    }

    public static String Xa() {
        return bVR;
    }

    public static String Xb() {
        return bVS != null ? bVS.WY() + File.separator + bVR : "";
    }

    public static String Xc() {
        return bVS != null ? bVS.WY() + File.separator + bVQ : "";
    }

    public static boolean Xd() {
        return bVT == 2;
    }

    public static boolean Xe() {
        return bVT == 1;
    }

    public static void p(Bundle bundle) {
        String f = s.f(bundle, "extraWSUrl");
        String f2 = s.f(bundle, "adb_debug_path");
        if (!TextUtils.isEmpty(f)) {
            bVS = new d();
            bVT = 1;
        } else if (!TextUtils.isEmpty(f2)) {
            bVS = new com.baidu.swan.apps.console.debugger.adbdebug.b();
            bVT = 2;
        } else {
            if (DEBUG) {
                Log.d("UserDebugParams", "not debug mode");
            }
            bVT = 0;
            bVS = null;
            return;
        }
        bVS.p(bundle);
    }

    public static void q(Bundle bundle) {
        if (bVS != null) {
            bVS.q(bundle);
        }
    }
}
