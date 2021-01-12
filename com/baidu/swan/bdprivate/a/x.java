package com.baidu.swan.bdprivate.a;
/* loaded from: classes6.dex */
public class x {
    private static volatile w dRl;

    public static synchronized w aPc() {
        w wVar;
        synchronized (x.class) {
            if (dRl == null) {
                dRl = new w();
            }
            wVar = dRl;
        }
        return wVar;
    }
}
