package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView HB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.HB = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.HB.Hq;
        view2 = this.HB.Hq;
        int width = view2.getWidth();
        i = this.HB.Hr;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.HB.invalidate();
    }
}
