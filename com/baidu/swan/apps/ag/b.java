package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dIb;

    public static void aKe() {
        c.dp(com.baidu.swan.apps.t.a.awW());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (dIb == null) {
            dIb = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.aKg();
                    b.b(bVar);
                }
            };
        }
        c.a(dIb);
    }

    public static void aKf() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (dIb != null) {
            c.b(dIb);
            dIb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aKg() {
        f.aAl().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity azV = f.aAl().azV();
        if (azV != null) {
            com.baidu.swan.apps.t.a.awX().b(azV, bVar.mImagePath, bVar.dIm);
        }
    }
}
