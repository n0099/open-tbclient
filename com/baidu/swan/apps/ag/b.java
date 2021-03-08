package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dJC;

    public static void aKh() {
        c.m27do(com.baidu.swan.apps.t.a.awZ());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (dJC == null) {
            dJC = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.aKj();
                    b.b(bVar);
                }
            };
        }
        c.a(dJC);
    }

    public static void aKi() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (dJC != null) {
            c.b(dJC);
            dJC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aKj() {
        f.aAo().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity azY = f.aAo().azY();
        if (azY != null) {
            com.baidu.swan.apps.t.a.axa().a(azY, bVar.mImagePath, bVar.dJN);
        }
    }
}
