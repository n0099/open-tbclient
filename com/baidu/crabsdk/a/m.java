package com.baidu.crabsdk.a;
/* loaded from: classes8.dex */
final class m implements Runnable {
    final /* synthetic */ long aoV;
    final /* synthetic */ long aoW;
    final /* synthetic */ long aoX;
    final /* synthetic */ long aoY;
    final /* synthetic */ l aoZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.aoZ = lVar;
        this.aoV = j;
        this.aoW = j2;
        this.aoX = j3;
        this.aoY = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.aoZ.aoU;
        iVar.c(this.aoV, this.aoW, this.aoX, this.aoY);
    }
}
