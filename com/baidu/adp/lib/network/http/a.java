package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a lu = null;

    public abstract void a(f fVar);

    public abstract String ac(String str);

    public static final a de() {
        return lu;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            lu = aVar;
        }
    }
}
