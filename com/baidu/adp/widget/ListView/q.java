package com.baidu.adp.widget.ListView;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ScrollView.g {
    final /* synthetic */ BdListView.i Cn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(BdListView.i iVar) {
        this.Cn = iVar;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void kB() {
        this.Cn.done();
    }
}
