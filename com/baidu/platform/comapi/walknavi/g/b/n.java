package com.baidu.platform.comapi.walknavi.g.b;
/* loaded from: classes2.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9663a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f9664b;

    public n(c cVar, String str) {
        this.f9664b = cVar;
        this.f9663a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.f9664b.c(this.f9663a);
    }
}
