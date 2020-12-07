package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes25.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cKM;
    private static String cKN;

    public static boolean aot() {
        return !TextUtils.isEmpty(cKM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean aou() {
        return TextUtils.equals(cKN, "update_tag_by_remote_debug");
    }

    public static void mY(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        cKN = str;
        if (TextUtils.equals(cKN, "update_tag_by_activity_on_new_intent")) {
            d.aom().aon();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aov() {
        cKN = "update_tag_by_remote_debug";
    }

    public static String aow() {
        return cKM + "/swan-core/master/master.html";
    }

    public static String aox() {
        return cKM + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        cKM = str;
    }
}
