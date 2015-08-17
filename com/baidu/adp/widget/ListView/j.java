package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ BdListView HU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.HU = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.HU.setSelection(this.HU.getCount() - 1);
    }
}
