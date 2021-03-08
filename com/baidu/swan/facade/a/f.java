package com.baidu.swan.facade.a;
/* loaded from: classes6.dex */
public class f {
    private static volatile e dXc;

    public static synchronized e aQp() {
        e eVar;
        synchronized (f.class) {
            if (dXc == null) {
                dXc = new e();
            }
            eVar = dXc;
        }
        return eVar;
    }
}
