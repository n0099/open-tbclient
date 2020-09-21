package com.baidu.mobads;
/* loaded from: classes3.dex */
class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.b = jVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.d.onUrl(this.a);
    }
}
