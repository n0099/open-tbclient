package com.baidu.adp.lib.e;
/* loaded from: classes.dex */
public class e {
    private static e a = new e();

    public static e a() {
        return a;
    }

    public void a(Runnable runnable) {
        new Thread(runnable).start();
    }
}
