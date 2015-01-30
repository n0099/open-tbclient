package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a fg = null;

    public static a bt() {
        if (fg == null) {
            synchronized (a.class) {
                if (fg == null) {
                    fg = new a();
                }
            }
        }
        return fg;
    }

    private a() {
    }
}
