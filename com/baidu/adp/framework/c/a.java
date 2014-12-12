package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a fe = null;

    public static a bv() {
        if (fe == null) {
            synchronized (a.class) {
                if (fe == null) {
                    fe = new a();
                }
            }
        }
        return fe;
    }

    private a() {
    }
}
