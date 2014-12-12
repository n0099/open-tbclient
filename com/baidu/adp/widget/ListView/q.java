package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ BdListView xm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(BdListView bdListView) {
        this.xm = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.xm.getContext());
        if (B != null) {
            B.onPreLoad(this.xm);
        }
    }
}
