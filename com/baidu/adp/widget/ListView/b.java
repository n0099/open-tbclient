package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView wq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.wq = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.wq.wf;
        view2 = this.wq.wf;
        int width = view2.getWidth();
        i = this.wq.wg;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.wq.invalidate();
    }
}
