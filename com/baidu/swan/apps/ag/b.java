package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dKJ;

    public static void aNF() {
        c.dr(com.baidu.swan.apps.t.a.aAs());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (dKJ == null) {
            dKJ = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.aNH();
                    b.b(bVar);
                }
            };
        }
        c.a(dKJ);
    }

    public static void aNG() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (dKJ != null) {
            c.b(dKJ);
            dKJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aNH() {
        f.aDH().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity aDr = f.aDH().aDr();
        if (aDr != null) {
            com.baidu.swan.apps.t.a.aAt().b(aDr, bVar.mImagePath, bVar.dKU);
        }
    }
}
