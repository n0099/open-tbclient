package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements e.a {
    final /* synthetic */ BdListView IZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.IZ = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void nh() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.IZ;
        runnable = this.IZ.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.IZ;
        runnable2 = this.IZ.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
