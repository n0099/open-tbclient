package com.baidu.crabsdk.a;
/* loaded from: classes5.dex */
final class m implements Runnable {
    final /* synthetic */ long apW;
    final /* synthetic */ long apX;
    final /* synthetic */ long apY;
    final /* synthetic */ long apZ;
    final /* synthetic */ l aqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.aqa = lVar;
        this.apW = j;
        this.apX = j2;
        this.apY = j3;
        this.apZ = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.aqa.apV;
        iVar.c(this.apW, this.apX, this.apY, this.apZ);
    }
}
