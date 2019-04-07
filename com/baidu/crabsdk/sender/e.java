package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {
    final /* synthetic */ d acu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.acu = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.acu;
        i = this.acu.acr;
        dVar.acr = (i + 1) % 10;
    }
}
