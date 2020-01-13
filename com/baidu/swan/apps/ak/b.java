package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.y.f;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bOg;

    public static void abA() {
        c.cq(com.baidu.swan.apps.w.a.RG());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (bOg == null) {
            bOg = new a() { // from class: com.baidu.swan.apps.ak.b.1
                @Override // com.baidu.swan.apps.ak.a
                public void a(c.b bVar) {
                    b.abC();
                }
            };
        }
        c.a(bOg);
    }

    public static void abB() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (bOg != null) {
            c.b(bOg);
            bOg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void abC() {
        f.UC().a(new com.baidu.swan.apps.n.a.b("onUserCaptureScreen"));
    }
}
