package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView HR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.HR = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.HR.HG;
        view2 = this.HR.HG;
        int width = view2.getWidth();
        i = this.HR.HH;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.HR.invalidate();
    }
}
