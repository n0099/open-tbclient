package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ BdListView xm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(BdListView bdListView) {
        this.xm = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.xm.setSelection(this.xm.getCount() - 1);
    }
}
