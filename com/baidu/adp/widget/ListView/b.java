package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView HS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.HS = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.HS.HH;
        view2 = this.HS.HH;
        int width = view2.getWidth();
        i = this.HS.HI;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.HS.invalidate();
    }
}
