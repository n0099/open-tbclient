package com.baidu.swan.facade.a;
/* loaded from: classes19.dex */
public class f {
    private static volatile e djA;

    public static synchronized e aHR() {
        e eVar;
        synchronized (f.class) {
            if (djA == null) {
                djA = new e();
            }
            eVar = djA;
        }
        return eVar;
    }
}
