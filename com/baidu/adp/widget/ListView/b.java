package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Bt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Bt = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Bt.Bi;
        view2 = this.Bt.Bi;
        int width = view2.getWidth();
        i = this.Bt.Bj;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Bt.invalidate();
    }
}
