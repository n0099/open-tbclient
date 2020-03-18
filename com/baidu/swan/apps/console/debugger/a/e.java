package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bku;
    private static String bkv;

    public static boolean LS() {
        return !TextUtils.isEmpty(bku);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean LT() {
        return TextUtils.equals(bkv, "update_tag_by_remote_debug");
    }

    public static void gD(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bkv = str;
        if (TextUtils.equals(bkv, "update_tag_by_activity_on_new_intent")) {
            d.LL().LM();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void LU() {
        bkv = "update_tag_by_remote_debug";
    }

    public static String LV() {
        return bku + "/swan-core/master/master.html";
    }

    public static String LW() {
        return bku + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bku = str;
    }
}
