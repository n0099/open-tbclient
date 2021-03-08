package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a Nd = null;

    public abstract void a(e eVar);

    public abstract String bJ(String str);

    public static final a lI() {
        return Nd;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            Nd = aVar;
        }
    }
}
