package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a Hx = null;

    public static a jG() {
        if (Hx == null) {
            synchronized (a.class) {
                if (Hx == null) {
                    Hx = new a();
                }
            }
        }
        return Hx;
    }

    private a() {
    }
}
