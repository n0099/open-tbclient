package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements m {
    final /* synthetic */ BdListView xj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BdListView bdListView) {
        this.xj = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public void jz() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.xj;
        runnable = this.xj.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.xj;
        runnable2 = this.xj.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
