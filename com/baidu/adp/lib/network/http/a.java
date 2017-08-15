package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a wM = null;

    public abstract void a(e eVar);

    public abstract String am(String str);

    public static final a ft() {
        return wM;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            wM = aVar;
        }
    }
}
