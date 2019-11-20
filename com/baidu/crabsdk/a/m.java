package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class m implements Runnable {
    final /* synthetic */ long Ja;
    final /* synthetic */ long Jb;
    final /* synthetic */ long Jc;
    final /* synthetic */ long Jd;
    final /* synthetic */ l Je;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.Je = lVar;
        this.Ja = j;
        this.Jb = j2;
        this.Jc = j3;
        this.Jd = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.Je.IY;
        iVar.c(this.Ja, this.Jb, this.Jc, this.Jd);
    }
}
