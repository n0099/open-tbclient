package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: b  reason: collision with root package name */
    public long f4697b;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f4696a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f4698c = new d.b.m.a.j(this);

    public n(long j) {
        this.f4697b = 0 == j ? 300L : j;
    }

    public abstract void b();

    public final void c() {
        if (this.f4696a.get()) {
            return;
        }
        this.f4696a.set(true);
        j.a().removeCallbacks(this.f4698c);
        j.a().postDelayed(this.f4698c, a.e());
    }

    public final void d() {
        if (this.f4696a.get()) {
            this.f4696a.set(false);
            j.a().removeCallbacks(this.f4698c);
        }
    }
}
