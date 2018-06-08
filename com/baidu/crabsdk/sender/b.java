package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Runnable {
    final /* synthetic */ a Tn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.Tn = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        a aVar = this.Tn;
        i = this.Tn.Tk;
        aVar.Tk = (i + 1) % 10;
    }
}
