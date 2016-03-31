package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ q Jp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.Jp = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Jp.Jm == null) {
            return;
        }
        this.Jp.Jm.ns();
    }
}
