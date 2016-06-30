package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r zE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.zE = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.zE.zB == null) {
            return;
        }
        this.zE.zB.jJ();
    }
}
