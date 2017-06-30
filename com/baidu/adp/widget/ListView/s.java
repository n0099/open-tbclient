package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r Ik;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.Ik = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Ik.Ih == null) {
            return;
        }
        this.Ik.Ih.lk();
    }
}
