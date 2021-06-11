package com.alipay.security.mobile.module.c;
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f2065a;

    public c(b bVar) {
        this.f2065a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f2065a.b();
        } catch (Exception e2) {
            d.a(e2);
        }
    }
}
