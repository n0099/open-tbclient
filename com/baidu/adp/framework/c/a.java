package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a hj = null;

    public static a bp() {
        if (hj == null) {
            synchronized (a.class) {
                if (hj == null) {
                    hj = new a();
                }
            }
        }
        return hj;
    }

    private a() {
    }
}
