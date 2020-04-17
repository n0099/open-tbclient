package com.baidu.swan.bdprivate.address;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cAT;

    public static synchronized a aqn() {
        a aVar;
        synchronized (b.class) {
            if (cAT == null) {
                cAT = new a();
            }
            aVar = cAT;
        }
        return aVar;
    }
}
