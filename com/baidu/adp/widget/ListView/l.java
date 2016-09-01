package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView Ce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.Ce = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void ks() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.Ce;
        runnable = this.Ce.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.Ce;
        runnable2 = this.Ce.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
