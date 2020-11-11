package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes10.dex */
public class b {
    public static void ey(boolean z) {
        e aHu = e.aHu();
        if (aHu != null) {
            a.alw().putBoolean(ms(aHu.getAppKey()), z);
        }
    }

    public static boolean mr(String str) {
        return !TextUtils.isEmpty(str) && a.alw().getBoolean(ms(str), false);
    }

    private static String ms(String str) {
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
        public static final class C0410a {
            private static final a cFe = new a();
        }

        public static a alw() {
            return C0410a.cFe;
        }
    }
}
