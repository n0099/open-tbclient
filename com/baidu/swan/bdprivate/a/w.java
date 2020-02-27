package com.baidu.swan.bdprivate.a;
/* loaded from: classes7.dex */
public class w {
    private static volatile v cbf;

    public static synchronized v ahO() {
        v vVar;
        synchronized (w.class) {
            if (cbf == null) {
                cbf = new v();
            }
            vVar = cbf;
        }
        return vVar;
    }
}
