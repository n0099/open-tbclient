package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f4442a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h f4443b;
    final /* synthetic */ b.C0298b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b.C0298b c0298b, boolean z, h hVar) {
        this.c = c0298b;
        this.f4442a = z;
        this.f4443b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f4442a) {
            gVar = b.this.d;
            gVar.b(com.baidu.platform.comapi.walknavi.d.a.g.b.b());
            gVar2 = b.this.d;
            gVar2.a(this.f4443b.f4445a);
        }
        if (!this.c.b()) {
            b.this.a(this.f4442a, true);
        }
    }
}
