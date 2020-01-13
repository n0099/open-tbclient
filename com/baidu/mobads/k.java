package com.baidu.mobads;
/* loaded from: classes8.dex */
class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ j aLb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.aLb = jVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aLb.aLa.onUrl(this.a);
    }
}
