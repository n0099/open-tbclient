package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView wn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.wn = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.wn.wc;
        view2 = this.wn.wc;
        int width = view2.getWidth();
        i = this.wn.wd;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.wn.invalidate();
    }
}
