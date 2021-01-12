package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f4226a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h f4227b;
    final /* synthetic */ b.C0281b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b.C0281b c0281b, boolean z, h hVar) {
        this.c = c0281b;
        this.f4226a = z;
        this.f4227b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f4226a) {
            gVar = b.this.d;
            gVar.b(com.baidu.platform.comapi.walknavi.d.a.g.b.b());
            gVar2 = b.this.d;
            gVar2.a(this.f4227b.f4229a);
        }
        if (!this.c.b()) {
            b.this.a(this.f4226a, true);
        }
    }
}
