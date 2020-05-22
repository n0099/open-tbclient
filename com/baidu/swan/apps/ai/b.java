package com.baidu.swan.apps.ai;

import android.util.Log;
import com.baidu.swan.apps.ai.c;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cDo;

    public static void apX() {
        c.ch(com.baidu.swan.apps.u.a.aeR());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (cDo == null) {
            cDo = new a() { // from class: com.baidu.swan.apps.ai.b.1
                @Override // com.baidu.swan.apps.ai.a
                public void a(c.b bVar) {
                    b.apZ();
                    b.b(bVar);
                }
            };
        }
        c.a(cDo);
    }

    public static void apY() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (cDo != null) {
            c.b(cDo);
            cDo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void apZ() {
        f.ahV().a(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        com.baidu.swan.apps.u.a.aeS().a(f.ahV().ahF(), bVar.mImagePath, bVar.cDA);
    }
}
