package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ q Jj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.Jj = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Jj.Jg == null) {
            return;
        }
        this.Jj.Jg.endAnimation();
    }
}
