package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ g aCf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.aCf = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.aCf.i();
        if (i) {
            this.aCf.j();
        }
    }
}
