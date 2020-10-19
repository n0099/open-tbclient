package com.baidu.swan.apps.console;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes10.dex */
public class b {
    public static void ec(boolean z) {
        e aDa = e.aDa();
        if (aDa != null) {
            a.ahc().putBoolean(lK(aDa.getAppKey()), z);
        }
    }

    public static boolean lJ(String str) {
        return !TextUtils.isEmpty(str) && a.ahc().getBoolean(lK(str), false);
    }

    private static String lK(String str) {
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
        public static final class C0384a {
            private static final a cqK = new a();
        }

        public static a ahc() {
            return C0384a.cqK;
        }
    }
}
