package com.baidu.swan.bdprivate.a;
/* loaded from: classes20.dex */
public class x {
    private static volatile w dtz;

    public static synchronized w aJI() {
        w wVar;
        synchronized (x.class) {
            if (dtz == null) {
                dtz = new w();
            }
            wVar = dtz;
        }
        return wVar;
    }
}
