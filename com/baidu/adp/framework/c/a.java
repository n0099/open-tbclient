package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends f {
    private static a c = null;

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private a() {
    }
}
