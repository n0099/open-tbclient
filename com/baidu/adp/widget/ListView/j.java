package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ BdListView IZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.IZ = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.IZ.setSelection(this.IZ.getCount() - 1);
    }
}
