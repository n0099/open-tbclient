package com.baidu.adp.lib.e;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f426a = new f();

    public static f a() {
        return f426a;
    }

    public void a(Runnable runnable) {
        new Thread(runnable).start();
    }
}
