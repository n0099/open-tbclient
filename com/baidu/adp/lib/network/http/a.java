package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a qz = null;

    public abstract void a(f fVar);

    public abstract String ak(String str);

    public static final a fL() {
        return qz;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            qz = aVar;
        }
    }
}
