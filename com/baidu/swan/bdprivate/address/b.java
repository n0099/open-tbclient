package com.baidu.swan.bdprivate.address;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cbF;

    public static synchronized a aia() {
        a aVar;
        synchronized (b.class) {
            if (cbF == null) {
                cbF = new a();
            }
            aVar = cbF;
        }
        return aVar;
    }
}
