package com.baidu.swan.facade.a;
/* loaded from: classes5.dex */
public class f {
    private static volatile e cbw;

    public static synchronized e agZ() {
        e eVar;
        synchronized (f.class) {
            if (cbw == null) {
                cbw = new e();
            }
            eVar = cbw;
        }
        return eVar;
    }
}
