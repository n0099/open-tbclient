package com.baidu.mobads;
/* loaded from: classes10.dex */
class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ j bsN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.bsN = jVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bsN.bsM.onUrl(this.a);
    }
}
