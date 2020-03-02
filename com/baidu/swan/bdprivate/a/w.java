package com.baidu.swan.bdprivate.a;
/* loaded from: classes7.dex */
public class w {
    private static volatile v cbg;

    public static synchronized v ahQ() {
        v vVar;
        synchronized (w.class) {
            if (cbg == null) {
                cbg = new v();
            }
            vVar = cbg;
        }
        return vVar;
    }
}
