package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements m {
    final /* synthetic */ BdListView xm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BdListView bdListView) {
        this.xm = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public void jH() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.xm;
        runnable = this.xm.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.xm;
        runnable2 = this.xm.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
