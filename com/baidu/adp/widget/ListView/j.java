package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ BdListView Ia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.Ia = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.base.j jVar;
        com.baidu.adp.base.j X;
        jVar = this.Ia.mScrollable;
        if (jVar != null) {
            X = this.Ia.mScrollable;
        } else {
            X = com.baidu.adp.base.k.X(this.Ia.getContext());
        }
        if (X != null) {
            X.onPreLoad(this.Ia);
        }
    }
}
