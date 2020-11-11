package com.baidu.platform.comapi.walknavi.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3062a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.f3062a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.g.c.c cVar;
        com.baidu.platform.comapi.walknavi.g.c.c cVar2;
        cVar = this.f3062a.i;
        if (cVar != null) {
            cVar2 = this.f3062a.i;
            cVar2.f();
        }
    }
}
