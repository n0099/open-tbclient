package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String crj;
    private static String crk;

    public static boolean ahz() {
        return !TextUtils.isEmpty(crj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean ahA() {
        return TextUtils.equals(crk, "update_tag_by_remote_debug");
    }

    public static void lP(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        crk = str;
        if (TextUtils.equals(crk, "update_tag_by_activity_on_new_intent")) {
            d.ahs().aht();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ahB() {
        crk = "update_tag_by_remote_debug";
    }

    public static String ahC() {
        return crj + "/swan-core/master/master.html";
    }

    public static String ahD() {
        return crj + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        crj = str;
    }
}
