package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class f implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ h b;
    final /* synthetic */ b.C0168b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b.C0168b c0168b, boolean z, h hVar) {
        this.c = c0168b;
        this.a = z;
        this.b = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.a) {
            gVar = b.this.d;
            gVar.b(com.baidu.platform.comapi.walknavi.d.a.g.b.b());
            gVar2 = b.this.d;
            gVar2.a(this.b.a);
        }
        if (!this.c.b()) {
            b.this.a(this.a, true);
        }
    }
}
