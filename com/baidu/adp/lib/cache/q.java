package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p td;
    private final /* synthetic */ String te;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str) {
        this.td = pVar;
        this.te = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.td.tc.U(this.te);
    }
}
