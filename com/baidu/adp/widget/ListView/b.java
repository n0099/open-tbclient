package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView yB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.yB = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.yB.yq;
        view2 = this.yB.yq;
        int width = view2.getWidth();
        i = this.yB.yr;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.yB.invalidate();
    }
}
