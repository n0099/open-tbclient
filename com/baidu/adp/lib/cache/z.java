package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x fQ;
    private final /* synthetic */ String fR;
    private final /* synthetic */ Object fT;
    private final /* synthetic */ long fU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str, Object obj, long j) {
        this.fQ = xVar;
        this.fR = str;
        this.fT = obj;
        this.fU = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fQ.a(this.fR, this.fT, this.fU);
    }
}
