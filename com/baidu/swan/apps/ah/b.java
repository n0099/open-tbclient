package com.baidu.swan.apps.ah;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ah.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dwM;

    public static void aIO() {
        c.cv(com.baidu.swan.apps.t.a.awA());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (dwM == null) {
            dwM = new a() { // from class: com.baidu.swan.apps.ah.b.1
                @Override // com.baidu.swan.apps.ah.a
                public void a(c.b bVar) {
                    b.aIQ();
                    b.b(bVar);
                }
            };
        }
        c.a(dwM);
    }

    public static void aIP() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (dwM != null) {
            c.b(dwM);
            dwM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aIQ() {
        f.azO().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity azy = f.azO().azy();
        if (azy != null) {
            com.baidu.swan.apps.t.a.awB().a(azy, bVar.mImagePath, bVar.dwY);
        }
    }
}
