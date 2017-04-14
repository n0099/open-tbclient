package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r Iv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.Iv = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Iv.Is == null) {
            return;
        }
        this.Iv.Is.lt();
    }
}
