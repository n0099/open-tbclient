package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements e.a {
    final /* synthetic */ BdListView HV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.HV = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void nu() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.HV;
        runnable = this.HV.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.HV;
        runnable2 = this.HV.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
