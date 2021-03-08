package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class a extends d {
    private static a Lb = null;

    public static a kX() {
        if (Lb == null) {
            synchronized (a.class) {
                if (Lb == null) {
                    Lb = new a();
                }
            }
        }
        return Lb;
    }

    private a() {
    }
}
