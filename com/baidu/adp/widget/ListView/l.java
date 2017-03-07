package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.a {
    final /* synthetic */ BdListView IF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.IF = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.e.a
    public void li() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.IF;
        runnable = this.IF.preLoadRunnable;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.IF;
        runnable2 = this.IF.preLoadRunnable;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
