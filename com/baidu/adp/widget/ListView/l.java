package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView zo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.zo = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void jy() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.zo;
        runnable = this.zo.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.zo;
        runnable2 = this.zo.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
