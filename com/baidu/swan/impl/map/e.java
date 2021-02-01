package com.baidu.swan.impl.map;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eoy;

    public static synchronized d bau() {
        d dVar;
        synchronized (e.class) {
            if (eoy == null) {
                eoy = new d();
            }
            dVar = eoy;
        }
        return dVar;
    }
}
