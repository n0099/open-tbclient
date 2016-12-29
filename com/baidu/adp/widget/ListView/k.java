package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView Cf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.Cf = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Cf.setSelection(this.Cf.getCount() - 1);
    }
}
