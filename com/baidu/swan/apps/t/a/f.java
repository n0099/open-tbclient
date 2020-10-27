package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class f {
    private static volatile e cRY;

    public static synchronized e avy() {
        e eVar;
        synchronized (f.class) {
            if (cRY == null) {
                cRY = new e();
            }
            eVar = cRY;
        }
        return eVar;
    }
}
