package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dKJ;

    public static void aNE() {
        c.dr(com.baidu.swan.apps.t.a.aAr());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (dKJ == null) {
            dKJ = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.aNG();
                    b.b(bVar);
                }
            };
        }
        c.a(dKJ);
    }

    public static void aNF() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (dKJ != null) {
            c.b(dKJ);
            dKJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aNG() {
        f.aDG().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity aDq = f.aDG().aDq();
        if (aDq != null) {
            com.baidu.swan.apps.t.a.aAs().b(aDq, bVar.mImagePath, bVar.dKU);
        }
    }
}
