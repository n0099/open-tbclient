package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qV = null;

    public static a dr() {
        if (qV == null) {
            synchronized (a.class) {
                if (qV == null) {
                    qV = new a();
                }
            }
        }
        return qV;
    }

    private a() {
    }
}
