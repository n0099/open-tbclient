package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a Ml = null;

    public abstract void a(e eVar);

    public abstract String bL(String str);

    public static final a ml() {
        return Ml;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            Ml = aVar;
        }
    }
}
