package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes8.dex */
public class b {
    public static void dI(boolean z) {
        e azI = e.azI();
        if (azI != null) {
            a.adH().putBoolean(kF(azI.getAppKey()), z);
        }
    }

    public static boolean kE(String str) {
        return !TextUtils.isEmpty(str) && a.adH().getBoolean(kF(str), false);
    }

    private static String kF(String str) {
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
        public static final class C0372a {
            private static final a ccr = new a();
        }

        public static a adH() {
            return C0372a.ccr;
        }
    }
}
