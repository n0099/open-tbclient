package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class f {
    private static volatile e cJC;

    public static synchronized e atE() {
        e eVar;
        synchronized (f.class) {
            if (cJC == null) {
                cJC = new e();
            }
            eVar = cJC;
        }
        return eVar;
    }
}
