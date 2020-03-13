package com.baidu.swan.facade.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e cfD;

    public static synchronized e ajp() {
        e eVar;
        synchronized (f.class) {
            if (cfD == null) {
                cfD = new e();
            }
            eVar = cfD;
        }
        return eVar;
    }
}
