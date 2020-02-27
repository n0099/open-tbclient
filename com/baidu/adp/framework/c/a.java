package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a oq = null;

    public static a fb() {
        if (oq == null) {
            synchronized (a.class) {
                if (oq == null) {
                    oq = new a();
                }
            }
        }
        return oq;
    }

    private a() {
    }
}
