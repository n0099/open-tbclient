package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Hk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Hk = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Hk.GZ;
        view2 = this.Hk.GZ;
        int width = view2.getWidth();
        i = this.Hk.Ha;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Hk.invalidate();
    }
}
