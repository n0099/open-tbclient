package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ x fQ;
    private final /* synthetic */ String fR;
    private final /* synthetic */ u fS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, String str, u uVar) {
        this.fQ = xVar;
        this.fR = str;
        this.fS = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fS.d(this.fR, this.fQ.get(this.fR));
    }
}
