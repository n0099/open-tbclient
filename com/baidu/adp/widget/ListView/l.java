package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView zP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.zP = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void jx() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.zP;
        runnable = this.zP.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.zP;
        runnable2 = this.zP.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
