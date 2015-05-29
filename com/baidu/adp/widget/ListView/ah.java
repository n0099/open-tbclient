package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class ah implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdTypeListView Ij;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(BdTypeListView bdTypeListView) {
        this.Ij = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Ij.Ii != null) {
            return this.Ij.Ii.onItemLongClick(adapterView, view, i, j);
        }
        return false;
    }
}
