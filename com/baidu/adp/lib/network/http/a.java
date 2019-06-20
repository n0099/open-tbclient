package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a zY = null;

    public abstract void a(e eVar);

    public abstract String az(String str);

    public static final a hT() {
        return zY;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            zY = aVar;
        }
    }
}
