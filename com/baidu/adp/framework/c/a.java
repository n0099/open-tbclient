package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a ol = null;

    public static a fa() {
        if (ol == null) {
            synchronized (a.class) {
                if (ol == null) {
                    ol = new a();
                }
            }
        }
        return ol;
    }

    private a() {
    }
}
