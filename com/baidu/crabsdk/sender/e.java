package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {
    final /* synthetic */ d arA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.arA = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.arA;
        i = this.arA.arx;
        dVar.arx = (i + 1) % 10;
    }
}
