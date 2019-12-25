package com.baidu.crabsdk.a;
/* loaded from: classes5.dex */
final class m implements Runnable {
    final /* synthetic */ l PD;
    final /* synthetic */ long Pw;
    final /* synthetic */ long Px;
    final /* synthetic */ long Py;
    final /* synthetic */ long Pz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.PD = lVar;
        this.Pw = j;
        this.Px = j2;
        this.Py = j3;
        this.Pz = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.PD.Pu;
        iVar.c(this.Pw, this.Px, this.Py, this.Pz);
    }
}
