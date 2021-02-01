package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a LC = null;

    public abstract void a(e eVar);

    public abstract String bF(String str);

    public static final a lI() {
        return LC;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            LC = aVar;
        }
    }
}
