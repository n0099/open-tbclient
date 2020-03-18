package com.baidu.swan.facade.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e cfO;

    public static synchronized e ajs() {
        e eVar;
        synchronized (f.class) {
            if (cfO == null) {
                cfO = new e();
            }
            eVar = cfO;
        }
        return eVar;
    }
}
