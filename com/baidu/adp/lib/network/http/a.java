package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a nP = null;

    public abstract void a(f fVar);

    public abstract String ad(String str);

    public static final a dZ() {
        return nP;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            nP = aVar;
        }
    }
}
