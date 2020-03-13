package com.baidu.swan.bdprivate.address;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cbH;

    public static synchronized a aic() {
        a aVar;
        synchronized (b.class) {
            if (cbH == null) {
                cbH = new a();
            }
            aVar = cbH;
        }
        return aVar;
    }
}
