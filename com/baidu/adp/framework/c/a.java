package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qu = null;

    public static a dr() {
        if (qu == null) {
            synchronized (a.class) {
                if (qu == null) {
                    qu = new a();
                }
            }
        }
        return qu;
    }

    private a() {
    }
}
