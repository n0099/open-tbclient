package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bIC;
    private static String bID;

    public static boolean TG() {
        return !TextUtils.isEmpty(bIC);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean TH() {
        return TextUtils.equals(bID, "update_tag_by_remote_debug");
    }

    public static void hQ(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bID = str;
        if (TextUtils.equals(bID, "update_tag_by_activity_on_new_intent")) {
            d.Tz().TA();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void TI() {
        bID = "update_tag_by_remote_debug";
    }

    public static String TJ() {
        return bIC + "/swan-core/master/master.html";
    }

    public static String TK() {
        return bIC + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bIC = str;
    }
}
