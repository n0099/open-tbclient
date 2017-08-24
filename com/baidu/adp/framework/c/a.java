package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a sE = null;

    public static a dB() {
        if (sE == null) {
            synchronized (a.class) {
                if (sE == null) {
                    sE = new a();
                }
            }
        }
        return sE;
    }

    private a() {
    }
}
