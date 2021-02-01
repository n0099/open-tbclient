package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cNj;
    private static String cNk;

    public static boolean amk() {
        return !TextUtils.isEmpty(cNj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean aml() {
        return TextUtils.equals(cNk, "update_tag_by_remote_debug");
    }

    public static void lY(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        cNk = str;
        if (TextUtils.equals(cNk, "update_tag_by_activity_on_new_intent")) {
            d.amd().ame();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void amm() {
        cNk = "update_tag_by_remote_debug";
    }

    public static String amn() {
        return cNj + "/swan-core/master/master.html";
    }

    public static String amo() {
        return cNj + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        cNj = str;
    }
}
