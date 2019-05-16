package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {
    final /* synthetic */ d aak;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aak = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aak;
        i = this.aak.aah;
        dVar.aah = (i + 1) % 10;
    }
}
