package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p tK;
    private final /* synthetic */ String tL;
    private final /* synthetic */ Object tN;
    private final /* synthetic */ long tO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, Object obj, long j) {
        this.tK = pVar;
        this.tL = str;
        this.tN = obj;
        this.tO = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tK.a(this.tL, this.tN, this.tO);
    }
}
