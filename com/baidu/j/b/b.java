package com.baidu.j.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a aPS;

    public static synchronized a Ew() {
        a aVar;
        synchronized (b.class) {
            if (aPS == null) {
                aPS = new a();
            }
            aVar = aPS;
        }
        return aVar;
    }
}
