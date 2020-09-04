package com.baidu.swan.apps.ah;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ah.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cUi;

    public static void aBc() {
        c.cq(com.baidu.swan.apps.t.a.aoJ());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (cUi == null) {
            cUi = new a() { // from class: com.baidu.swan.apps.ah.b.1
                @Override // com.baidu.swan.apps.ah.a
                public void a(c.b bVar) {
                    b.aBe();
                    b.b(bVar);
                }
            };
        }
        c.a(cUi);
    }

    public static void aBd() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (cUi != null) {
            c.b(cUi);
            cUi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aBe() {
        f.arY().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity arI = f.arY().arI();
        if (arI != null) {
            com.baidu.swan.apps.t.a.aoK().a(arI, bVar.mImagePath, bVar.cUu);
        }
    }
}
