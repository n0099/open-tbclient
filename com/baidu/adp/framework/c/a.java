package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a yy = null;

    public static a hj() {
        if (yy == null) {
            synchronized (a.class) {
                if (yy == null) {
                    yy = new a();
                }
            }
        }
        return yy;
    }

    private a() {
    }
}
