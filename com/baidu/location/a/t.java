package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class t extends Thread {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.a = pVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.a.i();
        if (i) {
            this.a.j();
        }
    }
}
