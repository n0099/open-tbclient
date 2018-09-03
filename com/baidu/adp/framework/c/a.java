package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a vt = null;

    public static a fN() {
        if (vt == null) {
            synchronized (a.class) {
                if (vt == null) {
                    vt = new a();
                }
            }
        }
        return vt;
    }

    private a() {
    }
}
