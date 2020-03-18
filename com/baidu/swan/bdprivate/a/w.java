package com.baidu.swan.bdprivate.a;
/* loaded from: classes7.dex */
public class w {
    private static volatile v cbt;

    public static synchronized v ahT() {
        v vVar;
        synchronized (w.class) {
            if (cbt == null) {
                cbt = new v();
            }
            vVar = cbt;
        }
        return vVar;
    }
}
