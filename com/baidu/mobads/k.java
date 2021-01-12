package com.baidu.mobads;
/* loaded from: classes14.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3380a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j f3381b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.f3381b = jVar;
        this.f3380a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3381b.d.onUrl(this.f3380a);
    }
}
