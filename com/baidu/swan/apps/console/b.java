package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes25.dex */
public class b {
    public static void eQ(boolean z) {
        e aJU = e.aJU();
        if (aJU != null) {
            a.anW().putBoolean(mT(aJU.getAppKey()), z);
        }
    }

    public static boolean mS(String str) {
        return !TextUtils.isEmpty(str) && a.anW().getBoolean(mT(str), false);
    }

    private static String mT(String str) {
        return "consoleSwitch" + str;
    }

    /* loaded from: classes25.dex */
    public static class a extends g {
        private a() {
            super("searchbox_sconsole_sp");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.apps.console.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C0420a {
            private static final a cKp = new a();
        }

        public static a anW() {
            return C0420a.cKp;
        }
    }
}
