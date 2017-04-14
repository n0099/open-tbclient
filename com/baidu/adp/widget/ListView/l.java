package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView If;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.If = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void lm() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.If;
        runnable = this.If.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.If;
        runnable2 = this.If.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
