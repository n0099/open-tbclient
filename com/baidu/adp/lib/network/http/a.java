package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a uF = null;

    public abstract void a(e eVar);

    public abstract String ag(String str);

    public static final a fh() {
        return uF;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            uF = aVar;
        }
    }
}
