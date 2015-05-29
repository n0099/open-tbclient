package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ BdListView HT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.HT = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.base.m B = com.baidu.adp.base.n.B(this.HT.getContext());
        if (B != null) {
            B.onPreLoad(this.HT);
        }
    }
}
