package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView zp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.zp = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void jv() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.zp;
        runnable = this.zp.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.zp;
        runnable2 = this.zp.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
