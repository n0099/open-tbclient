package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements i {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BdListView bdListView) {
        this.Ib = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void mU() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.Ib;
        runnable = this.Ib.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.Ib;
        runnable2 = this.Ib.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
