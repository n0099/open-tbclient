package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdTypeListView It;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(BdTypeListView bdTypeListView) {
        this.It = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.It.Is != null) {
            this.It.Is.onItemLongClick(adapterView, view, i, j);
            return false;
        }
        return false;
    }
}
