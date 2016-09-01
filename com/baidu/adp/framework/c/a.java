package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a jB = null;

    public static a ck() {
        if (jB == null) {
            synchronized (a.class) {
                if (jB == null) {
                    jB = new a();
                }
            }
        }
        return jB;
    }

    private a() {
    }
}
