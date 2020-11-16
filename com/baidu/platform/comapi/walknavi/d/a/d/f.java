package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2980a;
    final /* synthetic */ h b;
    final /* synthetic */ b.C0287b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b.C0287b c0287b, boolean z, h hVar) {
        this.c = c0287b;
        this.f2980a = z;
        this.b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f2980a) {
            gVar = b.this.d;
            gVar.b(com.baidu.platform.comapi.walknavi.d.a.g.b.b());
            gVar2 = b.this.d;
            gVar2.a(this.b.f2982a);
        }
        if (!this.c.b()) {
            b.this.a(this.f2980a, true);
        }
    }
}
