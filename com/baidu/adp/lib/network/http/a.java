package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a KO = null;

    public abstract void a(e eVar);

    public abstract String bG(String str);

    public static final a mg() {
        return KO;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            KO = aVar;
        }
    }
}
