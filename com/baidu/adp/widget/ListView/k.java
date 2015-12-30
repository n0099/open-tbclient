package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements e.a {
    final /* synthetic */ BdListView IE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.IE = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void mZ() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.IE;
        runnable = this.IE.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.IE;
        runnable2 = this.IE.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
