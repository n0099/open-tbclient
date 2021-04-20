package com.baidu.platform.comapi.walknavi.g;
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9691a;

    public f(a aVar) {
        this.f9691a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.g.b.c cVar;
        com.baidu.platform.comapi.walknavi.g.b.c cVar2;
        cVar = this.f9691a.k;
        if (cVar != null) {
            cVar2 = this.f9691a.k;
            cVar2.f();
        }
    }
}
