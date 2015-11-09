package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class s implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdTypeListView Io;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BdTypeListView bdTypeListView) {
        this.Io = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Io.In != null) {
            this.Io.In.onItemClick(adapterView, view, i, j);
        }
    }
}
