package com.baidu.swan.bdprivate.a;
/* loaded from: classes7.dex */
public class w {
    private static volatile v cAA;

    public static synchronized v aqa() {
        v vVar;
        synchronized (w.class) {
            if (cAA == null) {
                cAA = new v();
            }
            vVar = cAA;
        }
        return vVar;
    }
}
