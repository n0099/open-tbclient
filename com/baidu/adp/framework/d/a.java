package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class a extends d {
    private static a Kl = null;

    public static a lC() {
        if (Kl == null) {
            synchronized (a.class) {
                if (Kl == null) {
                    Kl = new a();
                }
            }
        }
        return Kl;
    }

    private a() {
    }
}
