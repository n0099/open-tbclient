package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements i {
    final /* synthetic */ BdListView Id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BdListView bdListView) {
        this.Id = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void mU() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.Id;
        runnable = this.Id.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.Id;
        runnable2 = this.Id.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
