package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdTypeListView xC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(BdTypeListView bdTypeListView) {
        this.xC = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.xC.xB != null) {
            this.xC.xB.onItemLongClick(adapterView, view, i, j);
            return false;
        }
        return false;
    }
}
