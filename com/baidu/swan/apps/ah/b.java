package com.baidu.swan.apps.ah;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ah.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes25.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dCe;

    public static void aLo() {
        c.db(com.baidu.swan.apps.t.a.aza());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (dCe == null) {
            dCe = new a() { // from class: com.baidu.swan.apps.ah.b.1
                @Override // com.baidu.swan.apps.ah.a
                public void a(c.b bVar) {
                    b.aLq();
                    b.b(bVar);
                }
            };
        }
        c.a(dCe);
    }

    public static void aLp() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (dCe != null) {
            c.b(dCe);
            dCe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aLq() {
        f.aCp().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity aBZ = f.aCp().aBZ();
        if (aBZ != null) {
            com.baidu.swan.apps.t.a.azb().a(aBZ, bVar.mImagePath, bVar.dCq);
        }
    }
}
