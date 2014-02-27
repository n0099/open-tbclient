package com.baidu.adp.lib.f;
/* loaded from: classes.dex */
public final class d {
    private static d a = new d();

    public static d a() {
        return a;
    }

    public static void a(Runnable runnable) {
        new Thread(runnable).start();
    }
}
