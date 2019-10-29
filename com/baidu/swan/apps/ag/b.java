package com.baidu.swan.apps.ag;

import android.util.Log;
import com.baidu.swan.apps.ag.c;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a bnw;

    static {
        c.bC(com.baidu.swan.apps.u.a.Ji());
    }

    public static void RS() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
        }
        if (bnw == null) {
            bnw = new a() { // from class: com.baidu.swan.apps.ag.b.1
                @Override // com.baidu.swan.apps.ag.a
                public void a(c.b bVar) {
                    b.RU();
                }
            };
        }
        c.a(bnw);
    }

    public static void RT() {
        if (DEBUG) {
            Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
        }
        if (bnw != null) {
            c.b(bnw);
            bnw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void RU() {
        e.LD().a(new com.baidu.swan.apps.m.a.b("onUserCaptureScreen"));
    }
}
