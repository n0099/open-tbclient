package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdTypeListView Ix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(BdTypeListView bdTypeListView) {
        this.Ix = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Ix.mTypeAdapter != null) {
            return this.Ix.mTypeAdapter.onItemLongClick(adapterView, view, i, j);
        }
        return false;
    }
}
