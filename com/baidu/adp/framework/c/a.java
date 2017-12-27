package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a aeU = null;

    public static a kV() {
        if (aeU == null) {
            synchronized (a.class) {
                if (aeU == null) {
                    aeU = new a();
                }
            }
        }
        return aeU;
    }

    private a() {
    }
}
