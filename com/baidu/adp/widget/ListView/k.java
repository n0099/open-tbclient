package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements e.a {
    final /* synthetic */ BdListView HW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.HW = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void nv() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.HW;
        runnable = this.HW.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.HW;
        runnable2 = this.HW.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
