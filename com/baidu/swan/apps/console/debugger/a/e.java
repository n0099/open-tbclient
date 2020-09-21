package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes3.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String ceS;
    private static String ceT;

    public static boolean aeO() {
        return !TextUtils.isEmpty(ceS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean aeP() {
        return TextUtils.equals(ceT, "update_tag_by_remote_debug");
    }

    public static void ld(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        ceT = str;
        if (TextUtils.equals(ceT, "update_tag_by_activity_on_new_intent")) {
            d.aeH().aeI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aeQ() {
        ceT = "update_tag_by_remote_debug";
    }

    public static String aeR() {
        return ceS + "/swan-core/master/master.html";
    }

    public static String aeS() {
        return ceS + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        ceS = str;
    }
}
