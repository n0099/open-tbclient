package com.baidu.crabsdk.a;
/* loaded from: classes3.dex */
final class m implements Runnable {
    final /* synthetic */ long Ze;
    final /* synthetic */ long Zf;
    final /* synthetic */ long Zg;
    final /* synthetic */ long Zh;
    final /* synthetic */ l Zi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, long j2, long j3, long j4) {
        this.Zi = lVar;
        this.Ze = j;
        this.Zf = j2;
        this.Zg = j3;
        this.Zh = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar;
        iVar = this.Zi.Zc;
        iVar.c(this.Ze, this.Zf, this.Zg, this.Zh);
    }
}
