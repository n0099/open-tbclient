package com.baidu.mobads;
/* loaded from: classes4.dex */
class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2419a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.b = kVar;
        this.f2419a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.d.onUrl(this.f2419a);
    }
}
