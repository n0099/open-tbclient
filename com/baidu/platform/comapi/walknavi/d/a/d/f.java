package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f9540a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f9541b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b.C0123b f9542c;

    public f(b.C0123b c0123b, boolean z, h hVar) {
        this.f9542c = c0123b;
        this.f9540a = z;
        this.f9541b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f9540a) {
            gVar = b.this.f9530d;
            gVar.b(com.baidu.platform.comapi.walknavi.d.a.g.b.b());
            gVar2 = b.this.f9530d;
            gVar2.a(this.f9541b.f9544a);
        }
        if (this.f9542c.b()) {
            return;
        }
        b.this.a(this.f9540a, true);
    }
}
