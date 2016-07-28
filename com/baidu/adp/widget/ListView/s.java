package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r Ag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.Ag = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Ag.Ac == null) {
            return;
        }
        this.Ag.Ac.jI();
    }
}
