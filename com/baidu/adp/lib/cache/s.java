package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p tS;
    private final /* synthetic */ Object tV;
    private final /* synthetic */ long tW;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str, Object obj, long j) {
        this.tS = pVar;
        this.val$key = str;
        this.tV = obj;
        this.tW = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tS.a(this.val$key, this.tV, this.tW);
    }
}
