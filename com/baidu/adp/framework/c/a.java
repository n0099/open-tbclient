package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a mu = null;

    public static a eG() {
        if (mu == null) {
            synchronized (a.class) {
                if (mu == null) {
                    mu = new a();
                }
            }
        }
        return mu;
    }

    private a() {
    }
}
