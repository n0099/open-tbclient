package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a uC = null;

    public abstract void a(e eVar);

    public abstract String ag(String str);

    public static final a fh() {
        return uC;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            uC = aVar;
        }
    }
}
