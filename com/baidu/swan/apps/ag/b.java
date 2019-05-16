package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a aTk;

    static {
        c.bB(com.baidu.swan.apps.u.a.DB());
    }

    public static void Mk() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (aTk == null) {
            aTk = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.Mm();
                }
            };
        }
        c.a(aTk);
    }

    public static void Ml() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (aTk != null) {
            c.b(aTk);
            aTk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Mm() {
        e.FV().a(new com.baidu.swan.apps.m.a.b("onUserCaptureScreen"));
    }
}
