package com.baidu.swan.bdprivate.address;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cAZ;

    public static synchronized a aqm() {
        a aVar;
        synchronized (b.class) {
            if (cAZ == null) {
                cAZ = new a();
            }
            aVar = cAZ;
        }
        return aVar;
    }
}
