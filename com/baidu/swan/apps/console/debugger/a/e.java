package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes7.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cDS;
    private static String cDT;

    public static boolean all() {
        return !TextUtils.isEmpty(cDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean alm() {
        return TextUtils.equals(cDT, "update_tag_by_remote_debug");
    }

    public static void mr(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        cDT = str;
        if (TextUtils.equals(cDT, "update_tag_by_activity_on_new_intent")) {
            d.ale().alf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aln() {
        cDT = "update_tag_by_remote_debug";
    }

    public static String alo() {
        return cDS + "/swan-core/master/master.html";
    }

    public static String alp() {
        return cDS + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        cDS = str;
    }
}
