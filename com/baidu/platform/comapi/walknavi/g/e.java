package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.g.b.c cVar;
        com.baidu.platform.comapi.walknavi.g.b.c cVar2;
        cVar = this.a.k;
        if (cVar != null) {
            cVar2 = this.a.k;
            cVar2.f();
        }
    }
}
