package com.baidu.swan.bdprivate.a;
/* loaded from: classes14.dex */
public class x {
    private static volatile w dfm;

    public static synchronized w aGp() {
        w wVar;
        synchronized (x.class) {
            if (dfm == null) {
                dfm = new w();
            }
            wVar = dfm;
        }
        return wVar;
    }
}
