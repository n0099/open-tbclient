package com.baidu.mobads;
/* loaded from: classes3.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3417a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j f3418b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.f3418b = jVar;
        this.f3417a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3418b.d.onUrl(this.f3417a);
    }
}
