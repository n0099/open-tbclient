package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cfM;

    public static synchronized a ajz() {
        a aVar;
        synchronized (b.class) {
            if (cfM == null) {
                cfM = new a();
            }
            aVar = cfM;
        }
        return aVar;
    }
}
