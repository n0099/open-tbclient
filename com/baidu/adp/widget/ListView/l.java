package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView Cf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.Cf = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void ks() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.Cf;
        runnable = this.Cf.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.Cf;
        runnable2 = this.Cf.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
