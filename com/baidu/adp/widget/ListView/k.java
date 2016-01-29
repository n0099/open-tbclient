package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements e.a {
    final /* synthetic */ BdListView IS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.IS = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void np() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.IS;
        runnable = this.IS.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.IS;
        runnable2 = this.IS.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
