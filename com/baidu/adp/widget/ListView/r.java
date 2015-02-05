package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ BdListView xj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(BdListView bdListView) {
        this.xj = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.xj.setSelection(this.xj.getCount() - 1);
    }
}
