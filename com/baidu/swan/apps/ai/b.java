package com.baidu.swan.apps.ai;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ai.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cLg;

    public static void asU() {
        c.cl(com.baidu.swan.apps.t.a.ahj());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (cLg == null) {
            cLg = new a() { // from class: com.baidu.swan.apps.ai.b.1
                @Override // com.baidu.swan.apps.ai.a
                public void a(c.b bVar) {
                    b.asW();
                    b.b(bVar);
                }
            };
        }
        c.a(cLg);
    }

    public static void asV() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (cLg != null) {
            c.b(cLg);
            cLg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void asW() {
        f.akr().a(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity akb = f.akr().akb();
        if (akb != null) {
            com.baidu.swan.apps.t.a.ahk().a(akb, bVar.mImagePath, bVar.cLt);
        }
    }
}
