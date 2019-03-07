package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static a aQr;

    static {
        c.cb(com.baidu.swan.apps.u.a.Cy());
    }

    public static void JM() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (aQr == null) {
            aQr = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.JO();
                }
            };
        }
        c.a(aQr);
    }

    public static void JN() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (aQr != null) {
            c.b(aQr);
            aQr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void JO() {
        e.Ec().a(new com.baidu.swan.apps.m.a.b("onUserCaptureScreen"));
    }
}
