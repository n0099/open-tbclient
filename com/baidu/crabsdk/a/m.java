package com.baidu.crabsdk.a;
/* loaded from: classes11.dex */
final class m implements Runnable {
    final /* synthetic */ long aoa;
    final /* synthetic */ long aob;
    final /* synthetic */ long aoc;
    final /* synthetic */ long aod;
    final /* synthetic */ l aoe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.aoe = lVar;
        this.aoa = j;
        this.aob = j2;
        this.aoc = j3;
        this.aod = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.aoe.anZ;
        iVar.c(this.aoa, this.aob, this.aoc, this.aod);
    }
}
