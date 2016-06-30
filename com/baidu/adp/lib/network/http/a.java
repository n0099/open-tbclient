package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a kR = null;

    public abstract void a(f fVar);

    public abstract String aa(String str);

    public static final a df() {
        return kR;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            kR = aVar;
        }
    }
}
