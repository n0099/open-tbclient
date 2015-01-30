package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView wt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.wt = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.wt.wi;
        view2 = this.wt.wi;
        int width = view2.getWidth();
        i = this.wt.wj;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.wt.invalidate();
    }
}
