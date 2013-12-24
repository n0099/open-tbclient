package com.baidu.adp.lib.f;
/* loaded from: classes.dex */
public class d {
    private static d a = new d();

    public static d a() {
        return a;
    }

    public void a(Runnable runnable) {
        new Thread(runnable).start();
    }
}
