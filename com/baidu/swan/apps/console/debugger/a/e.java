package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bkg;
    private static String bkh;

    public static boolean LP() {
        return !TextUtils.isEmpty(bkg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean LQ() {
        return TextUtils.equals(bkh, "update_tag_by_remote_debug");
    }

    public static void gE(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bkh = str;
        if (TextUtils.equals(bkh, "update_tag_by_activity_on_new_intent")) {
            d.LI().LJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void LR() {
        bkh = "update_tag_by_remote_debug";
    }

    public static String LS() {
        return bkg + "/swan-core/master/master.html";
    }

    public static String LT() {
        return bkg + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bkg = str;
    }
}
