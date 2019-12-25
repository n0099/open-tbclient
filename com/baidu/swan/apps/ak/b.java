package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.y.f;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bNw;

    public static void abd() {
        c.cq(com.baidu.swan.apps.w.a.Rk());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (bNw == null) {
            bNw = new a() { // from class: com.baidu.swan.apps.ak.b.1
                @Override // com.baidu.swan.apps.ak.a
                public void a(c.b bVar) {
                    b.abf();
                }
            };
        }
        c.a(bNw);
    }

    public static void abe() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (bNw != null) {
            c.b(bNw);
            bNw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void abf() {
        f.Uf().a(new com.baidu.swan.apps.n.a.b("onUserCaptureScreen"));
    }
}
