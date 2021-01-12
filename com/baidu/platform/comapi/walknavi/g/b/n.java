package com.baidu.platform.comapi.walknavi.g.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4310a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f4311b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar, String str) {
        this.f4311b = cVar;
        this.f4310a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.f4311b.c(this.f4310a);
    }
}
