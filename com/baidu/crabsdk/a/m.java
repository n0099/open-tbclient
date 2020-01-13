package com.baidu.crabsdk.a;
/* loaded from: classes6.dex */
final class m implements Runnable {
    final /* synthetic */ long PD;
    final /* synthetic */ long PE;
    final /* synthetic */ long PF;
    final /* synthetic */ long PG;
    final /* synthetic */ l PH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.PH = lVar;
        this.PD = j;
        this.PE = j2;
        this.PF = j3;
        this.PG = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.PH.Py;
        iVar.c(this.PD, this.PE, this.PF, this.PG);
    }
}
