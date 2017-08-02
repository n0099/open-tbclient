package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a vh = null;

    public abstract void a(e eVar);

    public abstract String ag(String str);

    public static final a fi() {
        return vh;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            vh = aVar;
        }
    }
}
