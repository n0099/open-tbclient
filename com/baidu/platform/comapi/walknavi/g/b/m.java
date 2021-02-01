package com.baidu.platform.comapi.walknavi.g.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4311a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f4312b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar, String str) {
        this.f4312b = cVar;
        this.f4311a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.f4312b.d(this.f4311a);
    }
}
