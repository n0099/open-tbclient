package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Ip;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Ip = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Ip.Ie;
        view2 = this.Ip.Ie;
        int width = view2.getWidth();
        i = this.Ip.If;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Ip.invalidate();
    }
}
