package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdTypeListView In;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(BdTypeListView bdTypeListView) {
        this.In = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.In.mTypeAdapter != null) {
            return this.In.mTypeAdapter.b(adapterView, view, i, j);
        }
        return false;
    }
}
