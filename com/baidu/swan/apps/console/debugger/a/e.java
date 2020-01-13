package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bfS;
    private static String bfT;

    public static boolean Jy() {
        return !TextUtils.isEmpty(bfS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Jz() {
        return TextUtils.equals(bfT, "update_tag_by_remote_debug");
    }

    public static void go(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bfT = str;
        if (TextUtils.equals(bfT, "update_tag_by_activity_on_new_intent")) {
            d.Jr().Js();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void JA() {
        bfT = "update_tag_by_remote_debug";
    }

    public static String JB() {
        return bfS + "/swan-core/master/master.html";
    }

    public static String JC() {
        return bfS + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bfS = str;
    }
}
