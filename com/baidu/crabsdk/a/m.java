package com.baidu.crabsdk.a;
/* loaded from: classes7.dex */
final class m implements Runnable {
    final /* synthetic */ long aoh;
    final /* synthetic */ long aoi;
    final /* synthetic */ long aoj;
    final /* synthetic */ long aok;
    final /* synthetic */ l aol;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.aol = lVar;
        this.aoh = j;
        this.aoi = j2;
        this.aoj = j3;
        this.aok = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.aol.aog;
        iVar.c(this.aoh, this.aoi, this.aoj, this.aok);
    }
}
