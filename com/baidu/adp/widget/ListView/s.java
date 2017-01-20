package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ r BH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.BH = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.BH.BE == null) {
            return;
        }
        this.BH.BE.kv();
    }
}
