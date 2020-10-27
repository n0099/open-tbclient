package com.baidu.crabsdk.a;
/* loaded from: classes11.dex */
final class m implements Runnable {
    final /* synthetic */ long aob;
    final /* synthetic */ long aoc;
    final /* synthetic */ long aod;
    final /* synthetic */ long aoe;
    final /* synthetic */ l aof;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.aof = lVar;
        this.aob = j;
        this.aoc = j2;
        this.aod = j3;
        this.aoe = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.aof.aoa;
        iVar.c(this.aob, this.aoc, this.aod, this.aoe);
    }
}
