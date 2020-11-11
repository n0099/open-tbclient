package com.baidu.swan.facade.a;
/* loaded from: classes20.dex */
public class f {
    private static volatile e dJV;

    public static synchronized e aOU() {
        e eVar;
        synchronized (f.class) {
            if (dJV == null) {
                dJV = new e();
            }
            eVar = dJV;
        }
        return eVar;
    }
}
