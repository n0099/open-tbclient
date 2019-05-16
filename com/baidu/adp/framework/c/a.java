package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a wh = null;

    public static a gd() {
        if (wh == null) {
            synchronized (a.class) {
                if (wh == null) {
                    wh = new a();
                }
            }
        }
        return wh;
    }

    private a() {
    }
}
