package com.baidu.swan.facade.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e dYh;

    public static synchronized e aTN() {
        e eVar;
        synchronized (f.class) {
            if (dYh == null) {
                dYh = new e();
            }
            eVar = dYh;
        }
        return eVar;
    }
}
