package com.baidu.swan.facade.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e cES;

    public static synchronized e arz() {
        e eVar;
        synchronized (f.class) {
            if (cES == null) {
                cES = new e();
            }
            eVar = cES;
        }
        return eVar;
    }
}
