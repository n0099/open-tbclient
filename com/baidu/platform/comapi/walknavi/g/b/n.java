package com.baidu.platform.comapi.walknavi.g.b;
/* loaded from: classes2.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10023a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f10024b;

    public n(c cVar, String str) {
        this.f10024b = cVar;
        this.f10023a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.f10024b.c(this.f10023a);
    }
}
