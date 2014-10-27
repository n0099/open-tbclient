package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements l {
    final /* synthetic */ BdListView vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(BdListView bdListView) {
        this.vg = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.l
    public void hL() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.vg;
        runnable = this.vg.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.vg;
        runnable2 = this.vg.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
