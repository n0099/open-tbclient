package com.baidu.swan.bdprivate.a;
/* loaded from: classes14.dex */
public class x {
    private static volatile w dfq;

    public static synchronized w aGp() {
        w wVar;
        synchronized (x.class) {
            if (dfq == null) {
                dfq = new w();
            }
            wVar = dfq;
        }
        return wVar;
    }
}
