package com.baidu.swan.bdprivate.a;
/* loaded from: classes20.dex */
public class x {
    private static volatile w dHO;

    public static synchronized w aOc() {
        w wVar;
        synchronized (x.class) {
            if (dHO == null) {
                dHO = new w();
            }
            wVar = dHO;
        }
        return wVar;
    }
}
