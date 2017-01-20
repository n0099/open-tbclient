package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a jv = null;

    public static a ci() {
        if (jv == null) {
            synchronized (a.class) {
                if (jv == null) {
                    jv = new a();
                }
            }
        }
        return jv;
    }

    private a() {
    }
}
