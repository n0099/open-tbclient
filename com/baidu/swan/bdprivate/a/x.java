package com.baidu.swan.bdprivate.a;
/* loaded from: classes19.dex */
public class x {
    private static volatile w dGg;

    public static synchronized w aNu() {
        w wVar;
        synchronized (x.class) {
            if (dGg == null) {
                dGg = new w();
            }
            wVar = dGg;
        }
        return wVar;
    }
}
