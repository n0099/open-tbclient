package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ BdListView zo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.zo = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.base.k q = com.baidu.adp.base.l.q(this.zo.getContext());
        if (q != null) {
            q.onPreLoad(this.zo);
        }
    }
}
