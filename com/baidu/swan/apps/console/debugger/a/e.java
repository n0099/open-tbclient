package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bIH;
    private static String bII;

    public static boolean TF() {
        return !TextUtils.isEmpty(bIH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean TG() {
        return TextUtils.equals(bII, "update_tag_by_remote_debug");
    }

    public static void hQ(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bII = str;
        if (TextUtils.equals(bII, "update_tag_by_activity_on_new_intent")) {
            d.Ty().Tz();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void TH() {
        bII = "update_tag_by_remote_debug";
    }

    public static String TI() {
        return bIH + "/swan-core/master/master.html";
    }

    public static String TJ() {
        return bIH + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bIH = str;
    }
}
