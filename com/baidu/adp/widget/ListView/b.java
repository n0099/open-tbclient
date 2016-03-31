package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Ik;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Ik = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Ik.HZ;
        view2 = this.Ik.HZ;
        int width = view2.getWidth();
        i = this.Ik.Ia;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Ik.invalidate();
    }
}
