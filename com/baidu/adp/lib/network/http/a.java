package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a Cq = null;

    public abstract void a(e eVar);

    public abstract String aP(String str);

    public static final a jb() {
        return Cq;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            Cq = aVar;
        }
    }
}
