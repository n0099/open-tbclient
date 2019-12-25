package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bfd;
    private static String bfe;

    public static boolean Jc() {
        return !TextUtils.isEmpty(bfd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Jd() {
        return TextUtils.equals(bfe, "update_tag_by_remote_debug");
    }

    public static void gl(String str) {
        if (DEBUG) {
            Log.d("RemoteDebugger", "Current launch mode is " + str);
        }
        bfe = str;
        if (TextUtils.equals(bfe, "update_tag_by_activity_on_new_intent")) {
            d.IV().IW();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Je() {
        bfe = "update_tag_by_remote_debug";
    }

    public static String Jf() {
        return bfd + "/swan-core/master/master.html";
    }

    public static String Jg() {
        return bfd + "/swan-core/slaves/slaves.html";
    }

    public static void setWebUrl(String str) {
        bfd = str;
    }
}
