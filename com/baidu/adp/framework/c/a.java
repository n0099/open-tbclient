package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a wg = null;

    public static a gd() {
        if (wg == null) {
            synchronized (a.class) {
                if (wg == null) {
                    wg = new a();
                }
            }
        }
        return wg;
    }

    private a() {
    }
}
