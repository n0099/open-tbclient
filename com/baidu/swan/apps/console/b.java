package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes9.dex */
public class b {
    public static void eX(boolean z) {
        e aIK = e.aIK();
        if (aIK != null) {
            a.alM().putBoolean(lT(aIK.getAppKey()), z);
        }
    }

    public static boolean lS(String str) {
        return !TextUtils.isEmpty(str) && a.alM().getBoolean(lT(str), false);
    }

    private static String lT(String str) {
        return "consoleSwitch" + str;
    }

    /* loaded from: classes9.dex */
    public static class a extends g {
        private a() {
            super("searchbox_sconsole_sp");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.apps.console.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C0392a {
            private static final a cMM = new a();
        }

        public static a alM() {
            return C0392a.cMM;
        }
    }
}
