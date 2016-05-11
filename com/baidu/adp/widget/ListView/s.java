package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r zF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.zF = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.zF.zC == null) {
            return;
        }
        this.zF.zC.jG();
    }
}
