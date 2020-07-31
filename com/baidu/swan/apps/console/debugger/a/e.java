package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes7.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bXd;
    private static String bXe;

    public static boolean XY() {
        return !TextUtils.isEmpty(bXd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean XZ() {
        return TextUtils.equals(bXe, "update_tag_by_remote_debug");
    }

    public static void jj(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bXe = str;
        if (TextUtils.equals(bXe, "update_tag_by_activity_on_new_intent")) {
            d.XR().XS();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Ya() {
        bXe = "update_tag_by_remote_debug";
    }

    public static String Yb() {
        return bXd + "/swan-core/master/master.html";
    }

    public static String Yc() {
        return bXd + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bXd = str;
    }
}
