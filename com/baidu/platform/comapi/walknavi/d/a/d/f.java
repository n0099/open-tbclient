package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f4229a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h f4230b;
    final /* synthetic */ b.C0285b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b.C0285b c0285b, boolean z, h hVar) {
        this.c = c0285b;
        this.f4229a = z;
        this.f4230b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f4229a) {
            gVar = b.this.d;
            gVar.b(com.baidu.platform.comapi.walknavi.d.a.g.b.b());
            gVar2 = b.this.d;
            gVar2.a(this.f4230b.f4232a);
        }
        if (!this.c.b()) {
            b.this.a(this.f4229a, true);
        }
    }
}
