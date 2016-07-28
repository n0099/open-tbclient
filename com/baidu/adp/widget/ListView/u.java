package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdTypeListView Aj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(BdTypeListView bdTypeListView) {
        this.Aj = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Aj.Ai != null) {
            return this.Aj.Ai.onItemLongClick(adapterView, view, i, j);
        }
        return false;
    }
}
