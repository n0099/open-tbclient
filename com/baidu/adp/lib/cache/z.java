package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x tC;
    private final /* synthetic */ Object tE;
    private final /* synthetic */ long tF;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str, Object obj, long j) {
        this.tC = xVar;
        this.val$key = str;
        this.tE = obj;
        this.tF = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tC.a(this.val$key, this.tE, this.tF);
    }
}
