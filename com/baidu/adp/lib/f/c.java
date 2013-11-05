package com.baidu.adp.lib.f;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f483a = new c();

    public static c a() {
        return f483a;
    }

    public void a(Runnable runnable) {
        new Thread(runnable).start();
    }
}
