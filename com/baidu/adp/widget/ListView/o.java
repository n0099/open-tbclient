package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements i {
    final /* synthetic */ BdListView HT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BdListView bdListView) {
        this.HT = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void nm() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.HT;
        runnable = this.HT.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.HT;
        runnable2 = this.HT.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
