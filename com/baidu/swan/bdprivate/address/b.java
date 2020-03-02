package com.baidu.swan.bdprivate.address;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cbG;

    public static synchronized a aic() {
        a aVar;
        synchronized (b.class) {
            if (cbG == null) {
                cbG = new a();
            }
            aVar = cbG;
        }
        return aVar;
    }
}
