package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a zl = null;

    public abstract void a(e eVar);

    public abstract String ay(String str);

    public static final a hG() {
        return zl;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            zl = aVar;
        }
    }
}
