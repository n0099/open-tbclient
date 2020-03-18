package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bSy;

    public static void adT() {
        c.ct(com.baidu.swan.apps.w.a.TZ());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (bSy == null) {
            bSy = new a() { // from class: com.baidu.swan.apps.ak.b.1
                @Override // com.baidu.swan.apps.ak.a
                public void a(c.b bVar) {
                    b.adV();
                }
            };
        }
        c.a(bSy);
    }

    public static void adU() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (bSy != null) {
            c.b(bSy);
            bSy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void adV() {
        f.WV().a(new com.baidu.swan.apps.n.a.b("onUserCaptureScreen"));
    }
}
