package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.Ib = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.base.j jVar;
        com.baidu.adp.base.j X;
        jVar = this.Ib.mScrollable;
        if (jVar != null) {
            X = this.Ib.mScrollable;
        } else {
            X = com.baidu.adp.base.k.X(this.Ib.getContext());
        }
        if (X != null) {
            X.onPreLoad(this.Ib);
        }
    }
}
