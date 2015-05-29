package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Hh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Hh = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Hh.GW;
        view2 = this.Hh.GW;
        int width = view2.getWidth();
        i = this.Hh.GX;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Hh.invalidate();
    }
}
