package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Hr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Hr = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Hr.Hg;
        view2 = this.Hr.Hg;
        int width = view2.getWidth();
        i = this.Hr.Hh;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Hr.invalidate();
    }
}
