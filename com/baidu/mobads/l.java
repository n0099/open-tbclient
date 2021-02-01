package com.baidu.mobads;
/* loaded from: classes5.dex */
class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3393a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f3394b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.f3394b = kVar;
        this.f3393a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3394b.d.onUrl(this.f3393a);
    }
}
