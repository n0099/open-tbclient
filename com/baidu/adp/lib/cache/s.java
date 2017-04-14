package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p tM;
    private final /* synthetic */ Object tP;
    private final /* synthetic */ long tQ;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str, Object obj, long j) {
        this.tM = pVar;
        this.val$key = str;
        this.tP = obj;
        this.tQ = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tM.a(this.val$key, this.tP, this.tQ);
    }
}
