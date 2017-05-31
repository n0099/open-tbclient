package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.Ib = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void onPreLoad() {
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
