package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView Br;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.Br = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void ko() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.Br;
        runnable = this.Br.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.Br;
        runnable2 = this.Br.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
