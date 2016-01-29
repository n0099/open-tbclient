package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Ie;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Ie = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Ie.HT;
        view2 = this.Ie.HT;
        int width = view2.getWidth();
        i = this.Ie.HU;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Ie.invalidate();
    }
}
