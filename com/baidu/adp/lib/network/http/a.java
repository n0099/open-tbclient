package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a Af = null;

    public abstract void a(e eVar);

    public abstract String aA(String str);

    public static final a id() {
        return Af;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            Af = aVar;
        }
    }
}
