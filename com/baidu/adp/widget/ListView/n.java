package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.Ib = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ib.setSelection(this.Ib.getCount() - 1);
    }
}
