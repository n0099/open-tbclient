package com.baidu.platform.comapi.walknavi.g.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3037a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar, String str) {
        this.b = cVar;
        this.f3037a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().G().d(true);
        this.b.d(this.f3037a);
    }
}
