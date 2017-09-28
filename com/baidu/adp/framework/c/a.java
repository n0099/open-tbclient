package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qs = null;

    public static a dr() {
        if (qs == null) {
            synchronized (a.class) {
                if (qs == null) {
                    qs = new a();
                }
            }
        }
        return qs;
    }

    private a() {
    }
}
