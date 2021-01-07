package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.f4561a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.g.c.c cVar;
        com.baidu.platform.comapi.walknavi.g.c.c cVar2;
        cVar = this.f4561a.i;
        if (cVar != null) {
            cVar2 = this.f4561a.i;
            cVar2.f();
        }
    }
}
