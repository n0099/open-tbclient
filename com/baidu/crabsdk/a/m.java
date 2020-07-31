package com.baidu.crabsdk.a;
/* loaded from: classes12.dex */
final class m implements Runnable {
    final /* synthetic */ long alK;
    final /* synthetic */ long alL;
    final /* synthetic */ long alM;
    final /* synthetic */ long alN;
    final /* synthetic */ l alO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.alO = lVar;
        this.alK = j;
        this.alL = j2;
        this.alM = j3;
        this.alN = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.alO.alJ;
        iVar.c(this.alK, this.alL, this.alM, this.alN);
    }
}
