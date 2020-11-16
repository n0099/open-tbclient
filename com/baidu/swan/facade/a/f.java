package com.baidu.swan.facade.a;
/* loaded from: classes19.dex */
public class f {
    private static volatile e dIn;

    public static synchronized e aOm() {
        e eVar;
        synchronized (f.class) {
            if (dIn == null) {
                dIn = new e();
            }
            eVar = dIn;
        }
        return eVar;
    }
}
