package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a vh = null;

    public abstract String Z(String str);

    public abstract void a(f fVar);

    public static final a fl() {
        return vh;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            vh = aVar;
        }
    }
}
