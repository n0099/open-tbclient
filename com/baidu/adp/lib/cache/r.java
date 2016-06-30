package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p jF;
    private final /* synthetic */ String jG;
    private final /* synthetic */ Object jI;
    private final /* synthetic */ long jJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, Object obj, long j) {
        this.jF = pVar;
        this.jG = str;
        this.jI = obj;
        this.jJ = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jF.a(this.jG, this.jI, this.jJ);
    }
}
