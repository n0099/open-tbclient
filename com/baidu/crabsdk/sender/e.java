package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class e implements Runnable {
    final /* synthetic */ d aoM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aoM = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aoM;
        i = this.aoM.aoJ;
        dVar.aoJ = (i + 1) % 10;
    }
}
