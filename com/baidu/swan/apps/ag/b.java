package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a aUs;

    static {
        c.bB(com.baidu.swan.apps.u.a.Eo());
    }

    public static void Nc() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (aUs == null) {
            aUs = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.Ne();
                }
            };
        }
        c.a(aUs);
    }

    public static void Nd() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (aUs != null) {
            c.b(aUs);
            aUs = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ne() {
        e.GJ().a(new com.baidu.swan.apps.m.a.b("onUserCaptureScreen"));
    }
}
