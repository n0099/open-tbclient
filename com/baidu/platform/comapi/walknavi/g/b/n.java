package com.baidu.platform.comapi.walknavi.g.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2984a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar, String str) {
        this.b = cVar;
        this.f2984a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.b.c(this.f2984a);
    }
}
