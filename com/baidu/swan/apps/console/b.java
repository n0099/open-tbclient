package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes9.dex */
public class b {
    public static void eZ(boolean z) {
        e aMl = e.aMl();
        if (aMl != null) {
            a.apj().putBoolean(mM(aMl.getAppKey()), z);
        }
    }

    public static boolean mL(String str) {
        return !TextUtils.isEmpty(str) && a.apj().getBoolean(mM(str), false);
    }

    private static String mM(String str) {
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
        public static final class C0412a {
            private static final a cPk = new a();
        }

        public static a apj() {
            return C0412a.cPk;
        }
    }
}
