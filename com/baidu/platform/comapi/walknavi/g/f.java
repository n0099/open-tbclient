package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3004a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f3004a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.g.b.c cVar;
        com.baidu.platform.comapi.walknavi.g.b.c cVar2;
        cVar = this.f3004a.k;
        if (cVar != null) {
            cVar2 = this.f3004a.k;
            cVar2.f();
        }
    }
}
