package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p tA;
    private final /* synthetic */ String tB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str) {
        this.tA = pVar;
        this.tB = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tA.remove(this.tB);
    }
}
