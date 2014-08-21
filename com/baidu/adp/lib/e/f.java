package com.baidu.adp.lib.e;
/* loaded from: classes.dex */
public class f {
    private static f a = new f();

    public static f a() {
        return a;
    }

    public void a(Runnable runnable) {
        new Thread(runnable).start();
    }
}
