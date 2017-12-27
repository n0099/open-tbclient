package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ g aAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.aAD = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.aAD.i();
        if (i) {
            this.aAD.j();
        }
    }
}
