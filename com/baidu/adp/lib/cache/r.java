package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p tA;
    private final /* synthetic */ String tB;
    private final /* synthetic */ Object tD;
    private final /* synthetic */ long tE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, Object obj, long j) {
        this.tA = pVar;
        this.tB = str;
        this.tD = obj;
        this.tE = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tA.a(this.tB, this.tD, this.tE);
    }
}
