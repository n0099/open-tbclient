package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ BdListView HW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.HW = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.HW.getContext());
        if (A != null) {
            A.onPreLoad(this.HW);
        }
    }
}
