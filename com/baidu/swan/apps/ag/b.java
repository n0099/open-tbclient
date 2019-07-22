package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a aTU;

    static {
        c.bB(com.baidu.swan.apps.u.a.Ek());
    }

    public static void MY() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (aTU == null) {
            aTU = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.Na();
                }
            };
        }
        c.a(aTU);
    }

    public static void MZ() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (aTU != null) {
            c.b(aTU);
            aTU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Na() {
        e.GF().a(new com.baidu.swan.apps.m.a.b("onUserCaptureScreen"));
    }
}
