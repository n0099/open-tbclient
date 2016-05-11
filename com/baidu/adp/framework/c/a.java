package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a gH = null;

    public static a bp() {
        if (gH == null) {
            synchronized (a.class) {
                if (gH == null) {
                    gH = new a();
                }
            }
        }
        return gH;
    }

    private a() {
    }
}
