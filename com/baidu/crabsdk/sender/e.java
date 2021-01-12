package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class e implements Runnable {
    final /* synthetic */ d aqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aqN = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aqN;
        i = this.aqN.aqK;
        dVar.aqK = (i + 1) % 10;
    }
}
