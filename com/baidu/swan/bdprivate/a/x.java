package com.baidu.swan.bdprivate.a;
/* loaded from: classes20.dex */
public class x {
    private static volatile w dBW;

    public static synchronized w aLC() {
        w wVar;
        synchronized (x.class) {
            if (dBW == null) {
                dBW = new w();
            }
            wVar = dBW;
        }
        return wVar;
    }
}
