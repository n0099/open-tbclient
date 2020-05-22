package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bRy;
    private static String bRz;

    public static boolean Wm() {
        return !TextUtils.isEmpty(bRy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Wn() {
        return TextUtils.equals(bRz, "update_tag_by_remote_debug");
    }

    public static void iR(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bRz = str;
        if (TextUtils.equals(bRz, "update_tag_by_activity_on_new_intent")) {
            d.Wf().Wg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Wo() {
        bRz = "update_tag_by_remote_debug";
    }

    public static String Wp() {
        return bRy + "/swan-core/master/master.html";
    }

    public static String Wq() {
        return bRy + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bRy = str;
    }
}
