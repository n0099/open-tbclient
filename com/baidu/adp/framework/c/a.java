package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a xM = null;

    public static a gV() {
        if (xM == null) {
            synchronized (a.class) {
                if (xM == null) {
                    xM = new a();
                }
            }
        }
        return xM;
    }

    private a() {
    }
}
