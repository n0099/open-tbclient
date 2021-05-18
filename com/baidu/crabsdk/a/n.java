package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: b  reason: collision with root package name */
    public long f4662b;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f4661a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f4663c = new d.a.m.a.j(this);

    public n(long j) {
        this.f4662b = 0 == j ? 300L : j;
    }

    public abstract void b();

    public final void c() {
        if (this.f4661a.get()) {
            return;
        }
        this.f4661a.set(true);
        j.a().removeCallbacks(this.f4663c);
        j.a().postDelayed(this.f4663c, a.e());
    }

    public final void d() {
        if (this.f4661a.get()) {
            this.f4661a.set(false);
            j.a().removeCallbacks(this.f4663c);
        }
    }
}
