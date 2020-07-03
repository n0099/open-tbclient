package com.baidu.swan.apps.ai;

import android.util.Log;
import com.baidu.swan.apps.ai.c;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cHY;

    public static void ard() {
        c.ci(com.baidu.swan.apps.u.a.afX());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (cHY == null) {
            cHY = new a() { // from class: com.baidu.swan.apps.ai.b.1
                @Override // com.baidu.swan.apps.ai.a
                public void a(c.b bVar) {
                    b.arf();
                    b.b(bVar);
                }
            };
        }
        c.a(cHY);
    }

    public static void are() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (cHY != null) {
            c.b(cHY);
            cHY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void arf() {
        f.ajb().a(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        com.baidu.swan.apps.u.a.afY().a(f.ajb().aiL(), bVar.mImagePath, bVar.cIk);
    }
}
