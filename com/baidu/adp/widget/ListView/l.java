package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView Ia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.Ia = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void onPreLoad() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.Ia;
        runnable = this.Ia.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.Ia;
        runnable2 = this.Ia.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
