package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView Ih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.Ih = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ih.setSelection(this.Ih.getCount() - 1);
    }
}
