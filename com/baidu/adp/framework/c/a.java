package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a yx = null;

    public static a hj() {
        if (yx == null) {
            synchronized (a.class) {
                if (yx == null) {
                    yx = new a();
                }
            }
        }
        return yx;
    }

    private a() {
    }
}
