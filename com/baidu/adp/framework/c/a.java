package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a pj = null;

    public static a cZ() {
        if (pj == null) {
            synchronized (a.class) {
                if (pj == null) {
                    pj = new a();
                }
            }
        }
        return pj;
    }

    private a() {
    }
}
