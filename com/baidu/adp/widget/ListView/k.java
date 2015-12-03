package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements e.a {
    final /* synthetic */ BdListView In;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.In = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void nB() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.In;
        runnable = this.In.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.In;
        runnable2 = this.In.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
