package com.baidu.adp.lib.d;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f392a = new b();

    public static b a() {
        return f392a;
    }

    public void a(Runnable runnable) {
        new Thread(runnable).start();
    }
}
