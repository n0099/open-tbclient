package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r Ix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.Ix = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Ix.Iu == null) {
            return;
        }
        this.Ix.Iu.lu();
    }
}
