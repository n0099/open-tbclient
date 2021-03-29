package com.baidu.platform.comapi.walknavi.g.b;
/* loaded from: classes2.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10105a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f10106b;

    public n(c cVar, String str) {
        this.f10106b = cVar;
        this.f10105a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.f10106b.c(this.f10105a);
    }
}
