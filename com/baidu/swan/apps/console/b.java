package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes8.dex */
public class b {
    public static void eX(boolean z) {
        e aIN = e.aIN();
        if (aIN != null) {
            a.alP().putBoolean(ma(aIN.getAppKey()), z);
        }
    }

    public static boolean lZ(String str) {
        return !TextUtils.isEmpty(str) && a.alP().getBoolean(ma(str), false);
    }

    private static String ma(String str) {
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
        public static final class C0398a {
            private static final a cOm = new a();
        }

        public static a alP() {
            return C0398a.cOm;
        }
    }
}
