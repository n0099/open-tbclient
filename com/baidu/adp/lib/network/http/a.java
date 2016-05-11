package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a kT = null;

    public abstract void a(f fVar);

    public abstract String aa(String str);

    public static final a de() {
        return kT;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            kT = aVar;
        }
    }
}
