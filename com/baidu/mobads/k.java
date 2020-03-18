package com.baidu.mobads;
/* loaded from: classes10.dex */
class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ j aPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.aPv = jVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aPv.aPu.onUrl(this.a);
    }
}
