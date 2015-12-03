package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    private final /* synthetic */ String tA;
    private final /* synthetic */ Object tC;
    private final /* synthetic */ long tD;
    final /* synthetic */ p tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, Object obj, long j) {
        this.tz = pVar;
        this.tA = str;
        this.tC = obj;
        this.tD = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tz.a(this.tA, this.tC, this.tD);
    }
}
