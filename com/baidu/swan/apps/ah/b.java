package com.baidu.swan.apps.ah;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ah.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes3.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cWi;

    public static void aBL() {
        c.cp(com.baidu.swan.apps.t.a.apu());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (cWi == null) {
            cWi = new a() { // from class: com.baidu.swan.apps.ah.b.1
                @Override // com.baidu.swan.apps.ah.a
                public void a(c.b bVar) {
                    b.aBN();
                    b.b(bVar);
                }
            };
        }
        c.a(cWi);
    }

    public static void aBM() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (cWi != null) {
            c.b(cWi);
            cWi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aBN() {
        f.asJ().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity ast = f.asJ().ast();
        if (ast != null) {
            com.baidu.swan.apps.t.a.apv().a(ast, bVar.mImagePath, bVar.cWu);
        }
    }
}
