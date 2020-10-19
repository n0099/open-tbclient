package com.baidu.swan.apps.ah;

import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ah.c;
import com.baidu.swan.apps.v.f;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a diq;

    public static void aEu() {
        c.cv(com.baidu.swan.apps.t.a.asf());
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (diq == null) {
            diq = new a() { // from class: com.baidu.swan.apps.ah.b.1
                @Override // com.baidu.swan.apps.ah.a
                public void a(c.b bVar) {
                    b.aEw();
                    b.b(bVar);
                }
            };
        }
        c.a(diq);
    }

    public static void aEv() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (diq != null) {
            c.b(diq);
            diq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aEw() {
        f.avu().b(new com.baidu.swan.apps.event.a.b("onUserCaptureScreen"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c.b bVar) {
        SwanAppActivity ave = f.avu().ave();
        if (ave != null) {
            com.baidu.swan.apps.t.a.asg().a(ave, bVar.mImagePath, bVar.diE);
        }
    }
}
