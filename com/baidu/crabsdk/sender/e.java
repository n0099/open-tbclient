package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class e implements Runnable {
    final /* synthetic */ d akS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.akS = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.akS;
        i = this.akS.akP;
        dVar.akP = (i + 1) % 10;
    }
}
