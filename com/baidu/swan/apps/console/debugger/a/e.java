package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cPH;
    private static String cPI;

    public static boolean apG() {
        return !TextUtils.isEmpty(cPH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean apH() {
        return TextUtils.equals(cPI, "update_tag_by_remote_debug");
    }

    public static void mR(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        cPI = str;
        if (TextUtils.equals(cPI, "update_tag_by_activity_on_new_intent")) {
            d.apz().apA();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void apI() {
        cPI = "update_tag_by_remote_debug";
    }

    public static String apJ() {
        return cPH + "/swan-core/master/master.html";
    }

    public static String apK() {
        return cPH + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        cPH = str;
    }
}
