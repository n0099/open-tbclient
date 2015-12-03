package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class t implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdTypeListView IG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(BdTypeListView bdTypeListView) {
        this.IG = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.IG.IF != null) {
            return this.IG.IF.onItemLongClick(adapterView, view, i, j);
        }
        return false;
    }
}
