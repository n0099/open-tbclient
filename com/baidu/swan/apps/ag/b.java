package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bne;

    static {
        c.bC(com.baidu.swan.apps.u.a.Jj());
    }

    public static void RU() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (bne == null) {
            bne = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.RW();
                }
            };
        }
        c.a(bne);
    }

    public static void RV() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (bne != null) {
            c.b(bne);
            bne = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void RW() {
        e.LE().a(new com.baidu.swan.apps.m.a.b("onUserCaptureScreen"));
    }
}
