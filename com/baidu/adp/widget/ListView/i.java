package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ BdListView IZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.IZ = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.base.k q = com.baidu.adp.base.l.q(this.IZ.getContext());
        if (q != null) {
            q.onPreLoad(this.IZ);
        }
    }
}
