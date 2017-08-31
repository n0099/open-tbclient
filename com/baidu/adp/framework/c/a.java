package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qr = null;

    public static a dr() {
        if (qr == null) {
            synchronized (a.class) {
                if (qr == null) {
                    qr = new a();
                }
            }
        }
        return qr;
    }

    private a() {
    }
}
