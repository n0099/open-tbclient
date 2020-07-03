package com.baidu.swan.bdprivate.a;
/* loaded from: classes7.dex */
public class w {
    private static volatile v cSp;

    public static synchronized v avO() {
        v vVar;
        synchronized (w.class) {
            if (cSp == null) {
                cSp = new v();
            }
            vVar = cSp;
        }
        return vVar;
    }
}
