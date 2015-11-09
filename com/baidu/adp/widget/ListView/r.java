package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ q Il;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.Il = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Il.Ii == null) {
            return;
        }
        this.Il.Ii.endAnimation();
    }
}
