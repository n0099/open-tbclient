package com.baidu.mobads;
/* loaded from: classes10.dex */
class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ j bxH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.bxH = jVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bxH.bxG.onUrl(this.a);
    }
}
