package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ g aBW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.aBW = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.aBW.i();
        if (i) {
            this.aBW.j();
        }
    }
}
