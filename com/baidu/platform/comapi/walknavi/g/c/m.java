package com.baidu.platform.comapi.walknavi.g.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4529a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f4530b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar, String str) {
        this.f4530b = cVar;
        this.f4529a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().G().d(true);
        this.f4530b.d(this.f4529a);
    }
}
