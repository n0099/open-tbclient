package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a vC = null;

    public static a fO() {
        if (vC == null) {
            synchronized (a.class) {
                if (vC == null) {
                    vC = new a();
                }
            }
        }
        return vC;
    }

    private a() {
    }
}
