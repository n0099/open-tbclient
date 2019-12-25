package com.baidu.mobads;
/* loaded from: classes7.dex */
class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ j aKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.aKj = jVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aKj.aKi.onUrl(this.a);
    }
}
