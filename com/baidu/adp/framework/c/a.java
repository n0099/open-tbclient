package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a gG = null;

    public static a bq() {
        if (gG == null) {
            synchronized (a.class) {
                if (gG == null) {
                    gG = new a();
                }
            }
        }
        return gG;
    }

    private a() {
    }
}
