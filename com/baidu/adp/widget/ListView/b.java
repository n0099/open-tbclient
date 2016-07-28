package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView ze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.ze = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.ze.yT;
        view2 = this.ze.yT;
        int width = view2.getWidth();
        i = this.ze.yU;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.ze.invalidate();
    }
}
