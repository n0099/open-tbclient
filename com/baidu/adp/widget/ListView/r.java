package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ q IT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.IT = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.IT.IQ == null) {
            return;
        }
        this.IT.IQ.endAnimation();
    }
}
