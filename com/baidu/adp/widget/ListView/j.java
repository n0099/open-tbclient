package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ BdListView HW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.HW = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.HW.setSelection(this.HW.getCount() - 1);
    }
}
