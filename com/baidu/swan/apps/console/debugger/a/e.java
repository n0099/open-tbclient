package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cOJ;
    private static String cOK;

    public static boolean amn() {
        return !TextUtils.isEmpty(cOJ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean amo() {
        return TextUtils.equals(cOK, "update_tag_by_remote_debug");
    }

    public static void mf(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        cOK = str;
        if (TextUtils.equals(cOK, "update_tag_by_activity_on_new_intent")) {
            d.amg().amh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void amp() {
        cOK = "update_tag_by_remote_debug";
    }

    public static String amq() {
        return cOJ + "/swan-core/master/master.html";
    }

    public static String amr() {
        return cOJ + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        cOJ = str;
    }
}
