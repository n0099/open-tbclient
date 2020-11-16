package com.baidu.swan.apps.ah;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ah.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a dvf;

    public static void aIg() {
        c.cv(com.baidu.swan.apps.t.a.avS());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (dvf == null) {
            dvf = new a() { // from class: com.baidu.swan.apps.ah.b.1
                @Override // com.baidu.swan.apps.ah.a
                public void a(c.b bVar) {
                    b.aIi();
                    b.b(bVar);
                }
            };
        }
        c.a(dvf);
    }

    public static void aIh() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (dvf != null) {
            c.b(dvf);
            dvf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aIi() {
        f.azg().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity ayQ = f.azg().ayQ();
        if (ayQ != null) {
            com.baidu.swan.apps.t.a.avT().a(ayQ, bVar.mImagePath, bVar.dvr);
        }
    }
}
