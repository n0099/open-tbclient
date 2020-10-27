package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes10.dex */
public class b {
    public static void ep(boolean z) {
        e aEU = e.aEU();
        if (aEU != null) {
            a.aiW().putBoolean(md(aEU.getAppKey()), z);
        }
    }

    public static boolean mc(String str) {
        return !TextUtils.isEmpty(str) && a.aiW().getBoolean(md(str), false);
    }

    private static String md(String str) {
        return "consoleSwitch" + str;
    }

    /* loaded from: classes10.dex */
    public static class a extends g {
        private a() {
            super("searchbox_sconsole_sp");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.apps.console.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C0398a {
            private static final a czl = new a();
        }

        public static a aiW() {
            return C0398a.czl;
        }
    }
}
