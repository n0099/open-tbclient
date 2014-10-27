package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdTypeListView vz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(BdTypeListView bdTypeListView) {
        this.vz = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.vz.vy != null) {
            this.vz.vy.onItemLongClick(adapterView, view, i, j);
            return false;
        }
        return false;
    }
}
