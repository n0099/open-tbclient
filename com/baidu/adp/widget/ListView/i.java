package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ BdListView In;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.In = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.In.getContext());
        if (A != null) {
            A.onPreLoad(this.In);
        }
    }
}
