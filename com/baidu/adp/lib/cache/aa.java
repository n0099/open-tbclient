package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ x fQ;
    private final /* synthetic */ String fR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, String str) {
        this.fQ = xVar;
        this.fR = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fQ.remove(this.fR);
    }
}
