package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a ti = null;

    public abstract void a(e eVar);

    public abstract String al(String str);

    public static final a eP() {
        return ti;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            ti = aVar;
        }
    }
}
