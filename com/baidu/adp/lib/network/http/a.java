package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a JK = null;

    public abstract void a(e eVar);

    public abstract String bA(String str);

    public static final a kr() {
        return JK;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            JK = aVar;
        }
    }
}
