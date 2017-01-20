package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Bc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Bc = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Bc.AR;
        view2 = this.Bc.AR;
        int width = view2.getWidth();
        i = this.Bc.AS;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Bc.invalidate();
    }
}
