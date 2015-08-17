package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Hi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Hi = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Hi.GX;
        view2 = this.Hi.GX;
        int width = view2.getWidth();
        i = this.Hi.GY;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Hi.invalidate();
    }
}
