package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a pi = null;

    public static a cZ() {
        if (pi == null) {
            synchronized (a.class) {
                if (pi == null) {
                    pi = new a();
                }
            }
        }
        return pi;
    }

    private a() {
    }
}
