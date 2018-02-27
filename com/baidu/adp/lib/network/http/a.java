package com.baidu.adp.lib.network.http;
/* loaded from: classes.dex */
public abstract class a {
    private static a aiM = null;

    public abstract void a(e eVar);

    public abstract String ao(String str);

    public static final a mL() {
        return aiM;
    }

    public static final void a(a aVar) {
        synchronized (a.class) {
            aiM = aVar;
        }
    }
}
