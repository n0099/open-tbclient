package com.baidu.swan.facade.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e cfC;

    public static synchronized e ajp() {
        e eVar;
        synchronized (f.class) {
            if (cfC == null) {
                cfC = new e();
            }
            eVar = cfC;
        }
        return eVar;
    }
}
