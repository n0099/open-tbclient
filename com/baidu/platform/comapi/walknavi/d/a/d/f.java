package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2982a;
    final /* synthetic */ h b;
    final /* synthetic */ b.C0298b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b.C0298b c0298b, boolean z, h hVar) {
        this.c = c0298b;
        this.f2982a = z;
        this.b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f2982a) {
            gVar = b.this.d;
            gVar.b(com.baidu.platform.comapi.walknavi.d.a.g.b.b());
            gVar2 = b.this.d;
            gVar2.a(this.b.f2984a);
        }
        if (!this.c.b()) {
            b.this.a(this.f2982a, true);
        }
    }
}
