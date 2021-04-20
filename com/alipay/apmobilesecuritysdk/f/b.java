package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f1765a = new b();

    /* renamed from: b  reason: collision with root package name */
    public Thread f1766b = null;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<Runnable> f1767c = new LinkedList<>();

    public static b a() {
        return f1765a;
    }

    public final synchronized void a(Runnable runnable) {
        this.f1767c.add(runnable);
        if (this.f1766b == null) {
            Thread thread = new Thread(new c(this));
            this.f1766b = thread;
            thread.start();
        }
    }
}
