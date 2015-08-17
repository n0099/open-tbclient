package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ q Ij;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.Ij = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Ij.Ig == null) {
            return;
        }
        this.Ij.Ig.endAnimation();
    }
}
