package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class a extends d {
    private static a Jt = null;

    public static a lC() {
        if (Jt == null) {
            synchronized (a.class) {
                if (Jt == null) {
                    Jt = new a();
                }
            }
        }
        return Jt;
    }

    private a() {
    }
}
