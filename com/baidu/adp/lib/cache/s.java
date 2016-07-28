package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ p ki;
    private final /* synthetic */ String kj;
    private final /* synthetic */ Object km;
    private final /* synthetic */ long kn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str, Object obj, long j) {
        this.ki = pVar;
        this.kj = str;
        this.km = obj;
        this.kn = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ki.a(this.kj, this.km, this.kn);
    }
}
