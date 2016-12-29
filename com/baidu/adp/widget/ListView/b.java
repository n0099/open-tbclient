package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Br;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Br = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Br.Bg;
        view2 = this.Br.Bg;
        int width = view2.getWidth();
        i = this.Br.Bh;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Br.invalidate();
    }
}
