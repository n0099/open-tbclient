package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a jC = null;

    public static a ck() {
        if (jC == null) {
            synchronized (a.class) {
                if (jC == null) {
                    jC = new a();
                }
            }
        }
        return jC;
    }

    private a() {
    }
}
