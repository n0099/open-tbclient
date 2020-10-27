package com.baidu.swan.apps.ah;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ah.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dqR;

    public static void aGo() {
        c.cv(com.baidu.swan.apps.t.a.aua());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (dqR == null) {
            dqR = new a() { // from class: com.baidu.swan.apps.ah.b.1
                @Override // com.baidu.swan.apps.ah.a
                public void a(c.b bVar) {
                    b.aGq();
                    b.b(bVar);
                }
            };
        }
        c.a(dqR);
    }

    public static void aGp() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (dqR != null) {
            c.b(dqR);
            dqR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aGq() {
        f.axo().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity awY = f.axo().awY();
        if (awY != null) {
            com.baidu.swan.apps.t.a.aub().a(awY, bVar.mImagePath, bVar.drd);
        }
    }
}
