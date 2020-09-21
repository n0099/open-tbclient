package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class a extends d {
    private static a Jd = null;

    public static a lB() {
        if (Jd == null) {
            synchronized (a.class) {
                if (Jd == null) {
                    Jd = new a();
                }
            }
        }
        return Jd;
    }

    private a() {
    }
}
