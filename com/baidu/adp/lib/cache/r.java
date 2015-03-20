package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p td;
    private final /* synthetic */ String te;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str) {
        this.td = pVar;
        this.te = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.td.tc.T(this.te);
    }
}
