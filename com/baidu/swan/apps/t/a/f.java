package com.baidu.swan.apps.t.a;
/* loaded from: classes14.dex */
public class f {
    private static volatile e cnO;

    public static synchronized e aiC() {
        e eVar;
        synchronized (f.class) {
            if (cnO == null) {
                cnO = new e();
            }
            eVar = cnO;
        }
        return eVar;
    }
}
