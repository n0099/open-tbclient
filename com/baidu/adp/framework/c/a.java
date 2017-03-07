package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a rr = null;

    public static a dr() {
        if (rr == null) {
            synchronized (a.class) {
                if (rr == null) {
                    rr = new a();
                }
            }
        }
        return rr;
    }

    private a() {
    }
}
