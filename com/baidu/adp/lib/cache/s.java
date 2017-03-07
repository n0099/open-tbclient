package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p up;
    private final /* synthetic */ String uq;
    private final /* synthetic */ Object ut;
    private final /* synthetic */ long uu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str, Object obj, long j) {
        this.up = pVar;
        this.uq = str;
        this.ut = obj;
        this.uu = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.up.a(this.uq, this.ut, this.uu);
    }
}
