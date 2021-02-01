package com.baidu.swan.bdprivate.a;
/* loaded from: classes7.dex */
public class x {
    private static volatile w dTr;

    public static synchronized w aPv() {
        w wVar;
        synchronized (x.class) {
            if (dTr == null) {
                dTr = new w();
            }
            wVar = dTr;
        }
        return wVar;
    }
}
