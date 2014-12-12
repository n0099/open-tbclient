package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdTypeListView xC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(BdTypeListView bdTypeListView) {
        this.xC = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.xC.xB != null) {
            this.xC.xB.onItemClick(adapterView, view, i, j);
        }
    }
}
