package com.baidu.platform.comapi.walknavi.g.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3041a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar, String str) {
        this.b = cVar;
        this.f3041a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().G().d(true);
        this.b.d(this.f3041a);
    }
}
