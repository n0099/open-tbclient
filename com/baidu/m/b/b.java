package com.baidu.m.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cnl;

    public static synchronized a afk() {
        a aVar;
        synchronized (b.class) {
            if (cnl == null) {
                cnl = new a();
            }
            aVar = cnl;
        }
        return aVar;
    }
}
