package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView zp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.zp = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.zp.setSelection(this.zp.getCount() - 1);
    }
}
