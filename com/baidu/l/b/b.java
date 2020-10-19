package com.baidu.l.b;
/* loaded from: classes20.dex */
public class b {
    private static volatile a bNm;

    public static synchronized a Ww() {
        a aVar;
        synchronized (b.class) {
            if (bNm == null) {
                bNm = new a();
            }
            aVar = bNm;
        }
        return aVar;
    }
}
