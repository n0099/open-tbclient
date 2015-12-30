package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p tB;
    private final /* synthetic */ String tC;
    private final /* synthetic */ Object tE;
    private final /* synthetic */ long tF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, Object obj, long j) {
        this.tB = pVar;
        this.tC = str;
        this.tE = obj;
        this.tF = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tB.a(this.tC, this.tE, this.tF);
    }
}
