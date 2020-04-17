package com.baidu.swan.facade.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e cEM;

    public static synchronized e arA() {
        e eVar;
        synchronized (f.class) {
            if (cEM == null) {
                cEM = new e();
            }
            eVar = cEM;
        }
        return eVar;
    }
}
