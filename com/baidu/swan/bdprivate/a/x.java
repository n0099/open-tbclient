package com.baidu.swan.bdprivate.a;
/* loaded from: classes19.dex */
public class x {
    private static volatile w dhq;

    public static synchronized w aGZ() {
        w wVar;
        synchronized (x.class) {
            if (dhq == null) {
                dhq = new w();
            }
            wVar = dhq;
        }
        return wVar;
    }
}
