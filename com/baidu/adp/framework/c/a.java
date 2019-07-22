package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a wj = null;

    public static a gm() {
        if (wj == null) {
            synchronized (a.class) {
                if (wj == null) {
                    wj = new a();
                }
            }
        }
        return wj;
    }

    private a() {
    }
}
