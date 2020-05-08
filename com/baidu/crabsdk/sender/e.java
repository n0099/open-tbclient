package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class e implements Runnable {
    final /* synthetic */ d akY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.akY = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.akY;
        i = this.akY.akV;
        dVar.akV = (i + 1) % 10;
    }
}
