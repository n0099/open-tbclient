package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class s implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdTypeListView IG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BdTypeListView bdTypeListView) {
        this.IG = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.IG.IF != null) {
            this.IG.IF.onItemClick(adapterView, view, i, j);
        }
    }
}
