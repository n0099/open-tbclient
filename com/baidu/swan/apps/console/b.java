package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes3.dex */
public class b {
    public static void dG(boolean z) {
        e aAr = e.aAr();
        if (aAr != null) {
            a.aer().putBoolean(kY(aAr.getAppKey()), z);
        }
    }

    public static boolean kX(String str) {
        return !TextUtils.isEmpty(str) && a.aer().getBoolean(kY(str), false);
    }

    private static String kY(String str) {
        return "consoleSwitch" + str;
    }

    /* loaded from: classes3.dex */
    public static class a extends g {
        private a() {
            super("searchbox_sconsole_sp");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.apps.console.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0367a {
            private static final a ceu = new a();
        }

        public static a aer() {
            return C0367a.ceu;
        }
    }
}
