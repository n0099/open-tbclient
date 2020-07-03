package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a Kk = null;

    public abstract void a(e eVar);

    public abstract String bB(String str);

    public static final a kH() {
        return Kk;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            Kk = aVar;
        }
    }
}
