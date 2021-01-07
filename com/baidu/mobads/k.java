package com.baidu.mobads;
/* loaded from: classes3.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3418a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j f3419b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.f3419b = jVar;
        this.f3418a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3419b.d.onUrl(this.f3418a);
    }
}
