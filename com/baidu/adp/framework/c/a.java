package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a vA = null;

    public static a fO() {
        if (vA == null) {
            synchronized (a.class) {
                if (vA == null) {
                    vA = new a();
                }
            }
        }
        return vA;
    }

    private a() {
    }
}
