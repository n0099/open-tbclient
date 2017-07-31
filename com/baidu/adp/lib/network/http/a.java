package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a wK = null;

    public abstract void a(e eVar);

    public abstract String am(String str);

    public static final a ft() {
        return wK;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            wK = aVar;
        }
    }
}
