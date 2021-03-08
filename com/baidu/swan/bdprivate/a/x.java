package com.baidu.swan.bdprivate.a;
/* loaded from: classes6.dex */
public class x {
    private static volatile w dUS;

    public static synchronized w aPy() {
        w wVar;
        synchronized (x.class) {
            if (dUS == null) {
                dUS = new w();
            }
            wVar = dUS;
        }
        return wVar;
    }
}
