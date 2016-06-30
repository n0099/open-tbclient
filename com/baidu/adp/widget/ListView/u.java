package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdTypeListView zH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(BdTypeListView bdTypeListView) {
        this.zH = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.zH.zG != null) {
            return this.zH.zG.onItemLongClick(adapterView, view, i, j);
        }
        return false;
    }
}
