package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView zP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.zP = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.zP.setSelection(this.zP.getCount() - 1);
    }
}
