package com.baidu.swan.facade.a;
/* loaded from: classes4.dex */
public class f {
    private static volatile e cbj;

    public static synchronized e agG() {
        e eVar;
        synchronized (f.class) {
            if (cbj == null) {
                cbj = new e();
            }
            eVar = cbj;
        }
        return eVar;
    }
}
