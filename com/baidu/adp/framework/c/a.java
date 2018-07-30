package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a vs = null;

    public static a fN() {
        if (vs == null) {
            synchronized (a.class) {
                if (vs == null) {
                    vs = new a();
                }
            }
        }
        return vs;
    }

    private a() {
    }
}
