package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements e.a {
    final /* synthetic */ BdListView HU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.HU = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void nw() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.HU;
        runnable = this.HU.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.HU;
        runnable2 = this.HU.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
