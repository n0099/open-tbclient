package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class t implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdTypeListView Io;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(BdTypeListView bdTypeListView) {
        this.Io = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Io.In != null) {
            return this.Io.In.onItemLongClick(adapterView, view, i, j);
        }
        return false;
    }
}
