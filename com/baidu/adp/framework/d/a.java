package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class a extends d {
    private static a Im = null;

    public static a jY() {
        if (Im == null) {
            synchronized (a.class) {
                if (Im == null) {
                    Im = new a();
                }
            }
        }
        return Im;
    }

    private a() {
    }
}
