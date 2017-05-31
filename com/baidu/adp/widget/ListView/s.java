package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r Il;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.Il = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Il.Ii == null) {
            return;
        }
        this.Il.Ii.lm();
    }
}
