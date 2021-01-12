package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dFX;

    public static void aJL() {
        c.dq(com.baidu.swan.apps.t.a.awy());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (dFX == null) {
            dFX = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.aJN();
                    b.b(bVar);
                }
            };
        }
        c.a(dFX);
    }

    public static void aJM() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (dFX != null) {
            c.b(dFX);
            dFX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aJN() {
        f.azN().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity azx = f.azN().azx();
        if (azx != null) {
            com.baidu.swan.apps.t.a.awz().b(azx, bVar.mImagePath, bVar.dGi);
        }
    }
}
