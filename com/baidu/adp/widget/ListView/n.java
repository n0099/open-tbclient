package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ BdListView HT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.HT = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.HT.setSelection(this.HT.getCount() - 1);
    }
}
