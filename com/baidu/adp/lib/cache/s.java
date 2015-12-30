package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p tB;
    private final /* synthetic */ String tC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str) {
        this.tB = pVar;
        this.tC = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tB.remove(this.tC);
    }
}
