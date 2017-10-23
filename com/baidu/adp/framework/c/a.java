package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qt = null;

    public static a dr() {
        if (qt == null) {
            synchronized (a.class) {
                if (qt == null) {
                    qt = new a();
                }
            }
        }
        return qt;
    }

    private a() {
    }
}
