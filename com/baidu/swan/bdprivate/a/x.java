package com.baidu.swan.bdprivate.a;
/* loaded from: classes7.dex */
public class x {
    private static volatile w dVX;

    public static synchronized w aSW() {
        w wVar;
        synchronized (x.class) {
            if (dVX == null) {
                dVX = new w();
            }
            wVar = dVX;
        }
        return wVar;
    }
}
