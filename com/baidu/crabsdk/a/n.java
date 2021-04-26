package com.baidu.crabsdk.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: b  reason: collision with root package name */
    public long f4808b;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f4807a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public Runnable f4809c = new d.a.m.a.j(this);

    public n(long j) {
        this.f4808b = 0 == j ? 300L : j;
    }

    public abstract void b();

    public final void c() {
        if (this.f4807a.get()) {
            return;
        }
        this.f4807a.set(true);
        j.a().removeCallbacks(this.f4809c);
        j.a().postDelayed(this.f4809c, a.e());
    }

    public final void d() {
        if (this.f4807a.get()) {
            this.f4807a.set(false);
            j.a().removeCallbacks(this.f4809c);
        }
    }
}
