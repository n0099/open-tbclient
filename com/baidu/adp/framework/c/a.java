package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a sB = null;

    public static a dB() {
        if (sB == null) {
            synchronized (a.class) {
                if (sB == null) {
                    sB = new a();
                }
            }
        }
        return sB;
    }

    private a() {
    }
}
