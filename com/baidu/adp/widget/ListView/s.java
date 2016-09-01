package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r Cu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.Cu = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Cu.Cr == null) {
            return;
        }
        this.Cu.Cr.kD();
    }
}
