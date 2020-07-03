package com.baidu.swan.facade.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e cTL;

    public static synchronized e awo() {
        e eVar;
        synchronized (f.class) {
            if (cTL == null) {
                cTL = new e();
            }
            eVar = cTL;
        }
        return eVar;
    }
}
