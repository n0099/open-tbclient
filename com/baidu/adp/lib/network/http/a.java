package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a qw = null;

    public abstract void a(e eVar);

    public abstract String ak(String str);

    public static final a fL() {
        return qw;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            qw = aVar;
        }
    }
}
