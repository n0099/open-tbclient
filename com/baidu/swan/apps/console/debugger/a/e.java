package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String ccQ;
    private static String ccR;

    public static boolean aee() {
        return !TextUtils.isEmpty(ccQ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean aef() {
        return TextUtils.equals(ccR, "update_tag_by_remote_debug");
    }

    public static void kK(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        ccR = str;
        if (TextUtils.equals(ccR, "update_tag_by_activity_on_new_intent")) {
            d.adX().adY();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aeg() {
        ccR = "update_tag_by_remote_debug";
    }

    public static String aeh() {
        return ccQ + "/swan-core/master/master.html";
    }

    public static String aei() {
        return ccQ + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        ccQ = str;
    }
}
