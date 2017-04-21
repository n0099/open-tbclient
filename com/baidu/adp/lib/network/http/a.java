package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a vg = null;

    public abstract String Z(String str);

    public abstract void a(f fVar);

    public static final a fl() {
        return vg;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            vg = aVar;
        }
    }
}
