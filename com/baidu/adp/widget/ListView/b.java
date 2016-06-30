package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView yD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.yD = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.yD.ys;
        view2 = this.yD.ys;
        int width = view2.getWidth();
        i = this.yD.yt;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.yD.invalidate();
    }
}
