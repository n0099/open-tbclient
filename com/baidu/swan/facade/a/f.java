package com.baidu.swan.facade.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e dVB;

    public static synchronized e aQm() {
        e eVar;
        synchronized (f.class) {
            if (dVB == null) {
                dVB = new e();
            }
            eVar = dVB;
        }
        return eVar;
    }
}
