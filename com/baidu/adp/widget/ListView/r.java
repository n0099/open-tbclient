package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ q Ik;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.Ik = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Ik.Ih == null) {
            return;
        }
        this.Ik.Ih.endAnimation();
    }
}
