package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView HQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.HQ = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.HQ.HF;
        view2 = this.HQ.HF;
        int width = view2.getWidth();
        i = this.HQ.HG;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.HQ.invalidate();
    }
}
