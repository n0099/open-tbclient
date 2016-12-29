package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r Cv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.Cv = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Cv.Cs == null) {
            return;
        }
        this.Cv.Cs.kD();
    }
}
