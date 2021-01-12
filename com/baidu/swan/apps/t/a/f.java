package com.baidu.swan.apps.t.a;
/* loaded from: classes6.dex */
public class f {
    private static volatile e ddj;

    public static synchronized e axX() {
        e eVar;
        synchronized (f.class) {
            if (ddj == null) {
                ddj = new e();
            }
            eVar = ddj;
        }
        return eVar;
    }
}
