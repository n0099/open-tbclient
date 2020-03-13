package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bkh;
    private static String bki;

    public static boolean LP() {
        return !TextUtils.isEmpty(bkh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean LQ() {
        return TextUtils.equals(bki, "update_tag_by_remote_debug");
    }

    public static void gE(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bki = str;
        if (TextUtils.equals(bki, "update_tag_by_activity_on_new_intent")) {
            d.LI().LJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void LR() {
        bki = "update_tag_by_remote_debug";
    }

    public static String LS() {
        return bkh + "/swan-core/master/master.html";
    }

    public static String LT() {
        return bkh + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bkh = str;
    }
}
