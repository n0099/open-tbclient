package com.baidu.swan.apps.ak;

import android.util.Log;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a crs;

    public static void alX() {
        c.bV(com.baidu.swan.apps.w.a.abN());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (crs == null) {
            crs = new a() { // from class: com.baidu.swan.apps.ak.b.1
                @Override // com.baidu.swan.apps.ak.a
                public void a(c.b bVar) {
                    b.alZ();
                }
            };
        }
        c.a(crs);
    }

    public static void alY() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (crs != null) {
            c.b(crs);
            crs = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void alZ() {
        f.aeJ().a(new com.baidu.swan.apps.n.a.b("onUserCaptureScreen"));
    }
}
