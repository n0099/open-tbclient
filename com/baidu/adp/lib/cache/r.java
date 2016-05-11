package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p jH;
    private final /* synthetic */ String jI;
    private final /* synthetic */ Object jK;
    private final /* synthetic */ long jL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, Object obj, long j) {
        this.jH = pVar;
        this.jI = str;
        this.jK = obj;
        this.jL = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jH.a(this.jI, this.jK, this.jL);
    }
}
