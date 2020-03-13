package com.baidu.swan.bdprivate.a;
/* loaded from: classes7.dex */
public class w {
    private static volatile v cbh;

    public static synchronized v ahQ() {
        v vVar;
        synchronized (w.class) {
            if (cbh == null) {
                cbh = new v();
            }
            vVar = cbh;
        }
        return vVar;
    }
}
