package com.baidu.swan.bdprivate.a;
/* loaded from: classes7.dex */
public class w {
    private static volatile v cAu;

    public static synchronized v aqb() {
        v vVar;
        synchronized (w.class) {
            if (cAu == null) {
                cAu = new v();
            }
            vVar = cAu;
        }
        return vVar;
    }
}
