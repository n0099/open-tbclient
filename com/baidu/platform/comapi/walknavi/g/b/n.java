package com.baidu.platform.comapi.walknavi.g.b;
/* loaded from: classes2.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10104a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f10105b;

    public n(c cVar, String str) {
        this.f10105b = cVar;
        this.f10104a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.f10105b.c(this.f10104a);
    }
}
