package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a oo = null;

    public static a fb() {
        if (oo == null) {
            synchronized (a.class) {
                if (oo == null) {
                    oo = new a();
                }
            }
        }
        return oo;
    }

    private a() {
    }
}
