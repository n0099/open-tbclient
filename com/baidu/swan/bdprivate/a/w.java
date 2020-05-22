package com.baidu.swan.bdprivate.a;
/* loaded from: classes7.dex */
public class w {
    private static volatile v cNF;

    public static synchronized v auI() {
        v vVar;
        synchronized (w.class) {
            if (cNF == null) {
                cNF = new v();
            }
            vVar = cNF;
        }
        return vVar;
    }
}
