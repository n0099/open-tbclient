package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bSl;

    public static void adO() {
        c.cu(com.baidu.swan.apps.w.a.TU());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (bSl == null) {
            bSl = new a() { // from class: com.baidu.swan.apps.ak.b.1
                @Override // com.baidu.swan.apps.ak.a
                public void a(c.b bVar) {
                    b.adQ();
                }
            };
        }
        c.a(bSl);
    }

    public static void adP() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (bSl != null) {
            c.b(bSl);
            bSl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void adQ() {
        f.WQ().a(new com.baidu.swan.apps.n.a.b("onUserCaptureScreen"));
    }
}
