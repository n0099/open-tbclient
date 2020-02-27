package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cfK;

    public static synchronized a ajx() {
        a aVar;
        synchronized (b.class) {
            if (cfK == null) {
                cfK = new a();
            }
            aVar = cfK;
        }
        return aVar;
    }
}
