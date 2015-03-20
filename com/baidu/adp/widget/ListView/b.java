package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView Hp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.Hp = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        view = this.Hp.He;
        view2 = this.Hp.He;
        int width = view2.getWidth();
        i = this.Hp.Hf;
        view.setLayoutParams(new AbsListView.LayoutParams(width, i));
        this.Hp.invalidate();
    }
}
