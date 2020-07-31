package com.baidu.mobads;
/* loaded from: classes20.dex */
class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ j bxW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.bxW = jVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bxW.bxV.onUrl(this.a);
    }
}
