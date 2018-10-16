package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a Co = null;

    public abstract void a(e eVar);

    public abstract String aP(String str);

    public static final a jb() {
        return Co;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            Co = aVar;
        }
    }
}
