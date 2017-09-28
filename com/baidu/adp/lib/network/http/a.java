package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a uE = null;

    public abstract void a(e eVar);

    public abstract String ag(String str);

    public static final a fh() {
        return uE;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            uE = aVar;
        }
    }
}
