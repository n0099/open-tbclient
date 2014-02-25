package com.baidu.adp.framework.e;
/* loaded from: classes.dex */
public class a extends d {
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
