package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ BdListView Ce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdListView bdListView) {
        this.Ce = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView.i iVar;
        BdListView.i iVar2;
        iVar = this.Ce.Cd;
        if (iVar != null) {
            iVar2 = this.Ce.Cd;
            iVar2.kA();
        }
    }
}
