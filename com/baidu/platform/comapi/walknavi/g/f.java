package com.baidu.platform.comapi.walknavi.g;
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10132a;

    public f(a aVar) {
        this.f10132a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.g.b.c cVar;
        com.baidu.platform.comapi.walknavi.g.b.c cVar2;
        cVar = this.f10132a.k;
        if (cVar != null) {
            cVar2 = this.f10132a.k;
            cVar2.f();
        }
    }
}
