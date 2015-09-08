package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    private final /* synthetic */ Object tB;
    private final /* synthetic */ long tC;
    final /* synthetic */ p ty;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, Object obj, long j) {
        this.ty = pVar;
        this.tz = str;
        this.tB = obj;
        this.tC = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ty.a(this.tz, this.tB, this.tC);
    }
}
