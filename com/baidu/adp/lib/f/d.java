package com.baidu.adp.lib.f;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f483a = new d();

    public static d a() {
        return f483a;
    }

    public void a(Runnable runnable) {
        new Thread(runnable).start();
    }
}
