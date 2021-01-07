package com.baidu.platform.comapi.walknavi.g.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4530a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f4531b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(c cVar, String str) {
        this.f4531b = cVar;
        this.f4530a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.walknavi.b.a().G().d(true);
        this.f4531b.d(this.f4530a);
    }
}
