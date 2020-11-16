package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes7.dex */
public class b {
    public static void eB(boolean z) {
        e aGM = e.aGM();
        if (aGM != null) {
            a.akO().putBoolean(mm(aGM.getAppKey()), z);
        }
    }

    public static boolean ml(String str) {
        return !TextUtils.isEmpty(str) && a.akO().getBoolean(mm(str), false);
    }

    private static String mm(String str) {
        return "consoleSwitch" + str;
    }

    /* loaded from: classes7.dex */
    public static class a extends g {
        private a() {
            super("searchbox_sconsole_sp");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.apps.console.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0408a {
            private static final a cDu = new a();
        }

        public static a akO() {
            return C0408a.cDu;
        }
    }
}
