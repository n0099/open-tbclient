package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a zp = null;

    public abstract void a(e eVar);

    public abstract String ax(String str);

    public static final a hG() {
        return zp;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            zp = aVar;
        }
    }
}
