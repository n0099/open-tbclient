package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cKV;
    private static String cKW;

    public static boolean alM() {
        return !TextUtils.isEmpty(cKV);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean alN() {
        return TextUtils.equals(cKW, "update_tag_by_remote_debug");
    }

    public static void lG(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        cKW = str;
        if (TextUtils.equals(cKW, "update_tag_by_activity_on_new_intent")) {
            d.alF().alG();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void alO() {
        cKW = "update_tag_by_remote_debug";
    }

    public static String alP() {
        return cKV + "/swan-core/master/master.html";
    }

    public static String alQ() {
        return cKV + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        cKV = str;
    }
}
