package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class e implements Runnable {
    final /* synthetic */ d aqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aqD = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aqD;
        i = this.aqD.aqA;
        dVar.aqA = (i + 1) % 10;
    }
}
