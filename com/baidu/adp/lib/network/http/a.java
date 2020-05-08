package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a JA = null;

    public abstract void a(e eVar);

    public abstract String bz(String str);

    public static final a kp() {
        return JA;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            JA = aVar;
        }
    }
}
