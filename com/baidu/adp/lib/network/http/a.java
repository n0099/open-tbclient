package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a qx = null;

    public abstract void a(e eVar);

    public abstract String ak(String str);

    public static final a fL() {
        return qx;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            qx = aVar;
        }
    }
}
