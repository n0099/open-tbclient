package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class f {
    private static volatile e cXR;

    public static synchronized e axY() {
        e eVar;
        synchronized (f.class) {
            if (cXR == null) {
                cXR = new e();
            }
            eVar = cXR;
        }
        return eVar;
    }
}
