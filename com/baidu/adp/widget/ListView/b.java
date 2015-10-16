package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Hj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Hj = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Hj.GY;
        view2 = this.Hj.GY;
        int width = view2.getWidth();
        i = this.Hj.GZ;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Hj.invalidate();
    }
}
