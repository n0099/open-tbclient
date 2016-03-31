package com.baidu.adp.lib.cache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ p tT;
    private final /* synthetic */ String tU;
    private final /* synthetic */ Object tW;
    private final /* synthetic */ long tX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, Object obj, long j) {
        this.tT = pVar;
        this.tU = str;
        this.tW = obj;
        this.tX = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tT.a(this.tU, this.tW, this.tX);
    }
}
