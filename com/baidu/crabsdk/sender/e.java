package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class e implements Runnable {
    final /* synthetic */ d aoO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aoO = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aoO;
        i = this.aoO.aoL;
        dVar.aoL = (i + 1) % 10;
    }
}
