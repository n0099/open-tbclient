package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bSm;

    public static void adQ() {
        c.cu(com.baidu.swan.apps.w.a.TW());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (bSm == null) {
            bSm = new a() { // from class: com.baidu.swan.apps.ak.b.1
                @Override // com.baidu.swan.apps.ak.a
                public void a(c.b bVar) {
                    b.adS();
                }
            };
        }
        c.a(bSm);
    }

    public static void adR() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (bSm != null) {
            c.b(bSm);
            bSm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void adS() {
        f.WS().a(new com.baidu.swan.apps.n.a.b("onUserCaptureScreen"));
    }
}
