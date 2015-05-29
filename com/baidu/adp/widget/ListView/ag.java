package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class ag implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdTypeListView Ij;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(BdTypeListView bdTypeListView) {
        this.Ij = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Ij.Ii != null) {
            this.Ij.Ii.onItemClick(adapterView, view, i, j);
        }
    }
}
