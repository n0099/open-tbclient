package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.b.a {
    final /* synthetic */ BdListView.i Id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(BdListView.i iVar) {
        this.Id = iVar;
    }

    @Override // com.baidu.adp.widget.b.a
    public void onOver() {
        this.Id.done();
    }
}
