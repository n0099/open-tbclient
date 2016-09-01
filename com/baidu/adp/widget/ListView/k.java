package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView Ce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.Ce = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ce.setSelection(this.Ce.getCount() - 1);
    }
}
