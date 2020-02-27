package com.baidu.swan.facade.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e cfB;

    public static synchronized e ajn() {
        e eVar;
        synchronized (f.class) {
            if (cfB == null) {
                cfB = new e();
            }
            eVar = cfB;
        }
        return eVar;
    }
}
