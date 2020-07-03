package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bWm;
    private static String bWn;

    public static boolean Xs() {
        return !TextUtils.isEmpty(bWm);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Xt() {
        return TextUtils.equals(bWn, "update_tag_by_remote_debug");
    }

    public static void iZ(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bWn = str;
        if (TextUtils.equals(bWn, "update_tag_by_activity_on_new_intent")) {
            d.Xl().Xm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Xu() {
        bWn = "update_tag_by_remote_debug";
    }

    public static String Xv() {
        return bWm + "/swan-core/master/master.html";
    }

    public static String Xw() {
        return bWm + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bWm = str;
    }
}
