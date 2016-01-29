package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p tK;
    private final /* synthetic */ String tL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str) {
        this.tK = pVar;
        this.tL = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tK.remove(this.tL);
    }
}
