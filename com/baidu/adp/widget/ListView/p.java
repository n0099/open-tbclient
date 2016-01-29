package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ScrollView.g {
    final /* synthetic */ BdListView.i Jb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BdListView.i iVar) {
        this.Jb = iVar;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void nz() {
        this.Jb.done();
    }
}
