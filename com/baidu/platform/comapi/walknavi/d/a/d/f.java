package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f9982a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f9983b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b.C0124b f9984c;

    public f(b.C0124b c0124b, boolean z, h hVar) {
        this.f9984c = c0124b;
        this.f9982a = z;
        this.f9983b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f9982a) {
            gVar = b.this.f9972d;
            gVar.b(com.baidu.platform.comapi.walknavi.d.a.g.b.b());
            gVar2 = b.this.f9972d;
            gVar2.a(this.f9983b.f9986a);
        }
        if (this.f9984c.b()) {
            return;
        }
        b.this.a(this.f9982a, true);
    }
}
