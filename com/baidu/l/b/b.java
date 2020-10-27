package com.baidu.l.b;
/* loaded from: classes20.dex */
public class b {
    private static volatile a bVJ;

    public static synchronized a Yq() {
        a aVar;
        synchronized (b.class) {
            if (bVJ == null) {
                bVJ = new a();
            }
            aVar = bVJ;
        }
        return aVar;
    }
}
