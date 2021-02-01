package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f4339a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.g.b.c cVar;
        com.baidu.platform.comapi.walknavi.g.b.c cVar2;
        cVar = this.f4339a.k;
        if (cVar != null) {
            cVar2 = this.f4339a.k;
            cVar2.f();
        }
    }
}
