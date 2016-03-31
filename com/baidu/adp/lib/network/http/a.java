package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a vc = null;

    public abstract void a(f fVar);

    public abstract String aj(String str);

    public static final a gQ() {
        return vc;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            vc = aVar;
        }
    }
}
