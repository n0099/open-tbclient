package com.baidu.adp.framework.d;
/* loaded from: classes.dex */
public class a extends d {
    private static a IU = null;

    public static a lx() {
        if (IU == null) {
            synchronized (a.class) {
                if (IU == null) {
                    IU = new a();
                }
            }
        }
        return IU;
    }

    private a() {
    }
}
