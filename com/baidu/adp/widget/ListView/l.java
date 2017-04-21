package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView Ih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.Ih = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void ln() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.Ih;
        runnable = this.Ih.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.Ih;
        runnable2 = this.Ih.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
