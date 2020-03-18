package com.baidu.swan.bdprivate.address;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cbS;

    public static synchronized a aif() {
        a aVar;
        synchronized (b.class) {
            if (cbS == null) {
                cbS = new a();
            }
            aVar = cbS;
        }
        return aVar;
    }
}
