package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p tR;
    private final /* synthetic */ Object tU;
    private final /* synthetic */ long tV;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str, Object obj, long j) {
        this.tR = pVar;
        this.val$key = str;
        this.tU = obj;
        this.tV = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tR.a(this.val$key, this.tU, this.tV);
    }
}
