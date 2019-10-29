package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a oF = null;

    public abstract void a(e eVar);

    public abstract String ag(String str);

    public static final a fx() {
        return oF;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            oF = aVar;
        }
    }
}
