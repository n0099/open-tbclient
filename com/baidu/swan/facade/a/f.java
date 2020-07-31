package com.baidu.swan.facade.a;
/* loaded from: classes14.dex */
public class f {
    private static volatile e cYo;

    public static synchronized e azc() {
        e eVar;
        synchronized (f.class) {
            if (cYo == null) {
                cYo = new e();
            }
            eVar = cYo;
        }
        return eVar;
    }
}
