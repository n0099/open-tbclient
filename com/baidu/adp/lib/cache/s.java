package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p tT;
    private final /* synthetic */ String tU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str) {
        this.tT = pVar;
        this.tU = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tT.remove(this.tU);
    }
}
