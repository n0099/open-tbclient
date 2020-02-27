package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bkf;
    private static String bkg;

    public static boolean LN() {
        return !TextUtils.isEmpty(bkf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean LO() {
        return TextUtils.equals(bkg, "update_tag_by_remote_debug");
    }

    public static void gE(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bkg = str;
        if (TextUtils.equals(bkg, "update_tag_by_activity_on_new_intent")) {
            d.LG().LH();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void LP() {
        bkg = "update_tag_by_remote_debug";
    }

    public static String LQ() {
        return bkf + "/swan-core/master/master.html";
    }

    public static String LR() {
        return bkf + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bkf = str;
    }
}
