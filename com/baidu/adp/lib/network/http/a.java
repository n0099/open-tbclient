package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a vg = null;

    public abstract void a(f fVar);

    public abstract String ae(String str);

    public static final a fk() {
        return vg;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            vg = aVar;
        }
    }
}
