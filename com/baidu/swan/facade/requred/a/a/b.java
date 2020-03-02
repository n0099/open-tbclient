package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cfL;

    public static synchronized a ajz() {
        a aVar;
        synchronized (b.class) {
            if (cfL == null) {
                cfL = new a();
            }
            aVar = cfL;
        }
        return aVar;
    }
}
