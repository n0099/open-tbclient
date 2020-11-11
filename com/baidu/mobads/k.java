package com.baidu.mobads;
/* loaded from: classes7.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2364a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.b = jVar;
        this.f2364a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.d.onUrl(this.f2364a);
    }
}
