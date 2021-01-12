package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes8.dex */
public class b {
    public static void eV(boolean z) {
        e aIr = e.aIr();
        if (aIr != null) {
            a.alo().putBoolean(lB(aIr.getAppKey()), z);
        }
    }

    public static boolean lA(String str) {
        return !TextUtils.isEmpty(str) && a.alo().getBoolean(lB(str), false);
    }

    private static String lB(String str) {
        return "consoleSwitch" + str;
    }

    /* loaded from: classes8.dex */
    public static class a extends g {
        private a() {
            super("searchbox_sconsole_sp");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.apps.console.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C0395a {
            private static final a cKy = new a();
        }

        public static a alo() {
            return C0395a.cKy;
        }
    }
}
