package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cFC;
    private static String cFD;

    public static boolean alT() {
        return !TextUtils.isEmpty(cFC);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean alU() {
        return TextUtils.equals(cFD, "update_tag_by_remote_debug");
    }

    public static void mx(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        cFD = str;
        if (TextUtils.equals(cFD, "update_tag_by_activity_on_new_intent")) {
            d.alM().alN();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void alV() {
        cFD = "update_tag_by_remote_debug";
    }

    public static String alW() {
        return cFC + "/swan-core/master/master.html";
    }

    public static String alX() {
        return cFC + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        cFC = str;
    }
}
