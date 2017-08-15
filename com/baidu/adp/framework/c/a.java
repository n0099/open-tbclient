package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a sD = null;

    public static a dB() {
        if (sD == null) {
            synchronized (a.class) {
                if (sD == null) {
                    sD = new a();
                }
            }
        }
        return sD;
    }

    private a() {
    }
}
