package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdTypeListView zI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(BdTypeListView bdTypeListView) {
        this.zI = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.zI.zH != null) {
            this.zI.zH.onItemClick(adapterView, view, i, j);
        }
    }
}
