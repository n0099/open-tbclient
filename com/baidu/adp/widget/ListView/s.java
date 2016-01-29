package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class s implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdTypeListView Jm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BdTypeListView bdTypeListView) {
        this.Jm = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Jm.Jl != null) {
            this.Jm.Jl.onItemClick(adapterView, view, i, j);
        }
    }
}
