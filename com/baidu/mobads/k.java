package com.baidu.mobads;
/* loaded from: classes10.dex */
class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ j aPg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.aPg = jVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aPg.aPf.onUrl(this.a);
    }
}
