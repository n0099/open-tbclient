package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a aQw;

    static {
        c.cb(com.baidu.swan.apps.u.a.Cw());
    }

    public static void JK() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (aQw == null) {
            aQw = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.JM();
                }
            };
        }
        c.a(aQw);
    }

    public static void JL() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (aQw != null) {
            c.b(aQw);
            aQw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void JM() {
        e.Ea().a(new com.baidu.swan.apps.m.a.b("onUserCaptureScreen"));
    }
}
