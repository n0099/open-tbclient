package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ BdListView vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(BdListView bdListView) {
        this.vg = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vg.setSelection(this.vg.getCount() - 1);
    }
}
