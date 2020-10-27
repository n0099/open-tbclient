package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String czJ;
    private static String czK;

    public static boolean ajt() {
        return !TextUtils.isEmpty(czJ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean aju() {
        return TextUtils.equals(czK, "update_tag_by_remote_debug");
    }

    public static void mi(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        czK = str;
        if (TextUtils.equals(czK, "update_tag_by_activity_on_new_intent")) {
            d.ajm().ajn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ajv() {
        czK = "update_tag_by_remote_debug";
    }

    public static String ajw() {
        return czJ + "/swan-core/master/master.html";
    }

    public static String ajx() {
        return czJ + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        czJ = str;
    }
}
