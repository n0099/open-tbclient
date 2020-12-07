package com.baidu.swan.bdprivate.a;
/* loaded from: classes20.dex */
public class x {
    private static volatile w dNe;

    public static synchronized w aQA() {
        w wVar;
        synchronized (x.class) {
            if (dNe == null) {
                dNe = new w();
            }
            wVar = dNe;
        }
        return wVar;
    }
}
