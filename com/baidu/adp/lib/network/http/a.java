package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a zr = null;

    public abstract void a(e eVar);

    public abstract String ax(String str);

    public static final a hG() {
        return zr;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            zr = aVar;
        }
    }
}
