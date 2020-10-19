package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a Ln = null;

    public abstract void a(e eVar);

    public abstract String bI(String str);

    public static final a ml() {
        return Ln;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            Ln = aVar;
        }
    }
}
