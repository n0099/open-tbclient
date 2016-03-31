package com.baidu.adp.framework.c;
/* loaded from: classes.dex */
public class a extends d {
    private static a qT = null;

    public static a eZ() {
        if (qT == null) {
            synchronized (a.class) {
                if (qT == null) {
                    qT = new a();
                }
            }
        }
        return qT;
    }

    private a() {
    }
}
