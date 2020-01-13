package com.baidu.j.b;
/* loaded from: classes5.dex */
public class b {
    private static volatile a aLs;

    public static synchronized a BY() {
        a aVar;
        synchronized (b.class) {
            if (aLs == null) {
                aLs = new a();
            }
            aVar = aLs;
        }
        return aVar;
    }
}
